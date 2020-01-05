package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.dao.AttrDao;
import com.atguigu.gmall.pms.dao.SkuInfoDao;
import com.atguigu.gmall.pms.dao.SpuInfoDescDao;
import com.atguigu.gmall.pms.entity.*;
import com.atguigu.gmall.pms.feign.SmsFeign;
import com.atguigu.gmall.pms.service.ProductAttrValueService;
import com.atguigu.gmall.pms.service.SkuImagesService;
import com.atguigu.gmall.pms.service.SkuSaleAttrValueService;
import com.atguigu.gmall.pms.vo.ProductAttrValueVo;
import com.atguigu.gmall.pms.vo.SkuInfoVo;
import com.atguigu.gmall.pms.vo.SpuInfoVo;
import com.atguigu.gmall.vo.SkuSaleVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.pms.dao.SpuInfoDao;
import com.atguigu.gmall.pms.service.SpuInfoService;
import org.springframework.util.CollectionUtils;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SkuInfoDao skuInfoDao;
    @Autowired
    private SpuInfoDescDao spuInfoDescDao;
    @Autowired
    private SkuImagesService skuImagesService;
    @Autowired
    private ProductAttrValueService productAttrValueService;
    @Autowired
    private AttrDao attrDao;
    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;
    @Autowired
    private SmsFeign smsFeign;
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryByCidOrKey(QueryCondition condition, Long catId) {
        IPage<SpuInfoEntity> page = new Query<SpuInfoEntity>().getPage(condition);
        QueryWrapper<SpuInfoEntity> wrapper = new QueryWrapper<>();
        if(catId!=0){

            wrapper.eq("catalog_id",catId);
        }
        String key = condition.getKey();
        if (StringUtils.isNotBlank(key)){

            wrapper.and(t->t.like("spu_name",key).or().like("id",key));

        }
        PageVo pageVo = new PageVo(this.page(page, wrapper));
        return pageVo;
    }

    @Override
    public void bigsave(SpuInfoVo spuInfo) {

        //1.1先保存spuinfo信息
        spuInfo.setPublishStatus(1);
        spuInfo.setCreateTime(new Date());
        spuInfo.setUodateTime(spuInfo.getCreateTime());
        this.save(spuInfo);
        Long spuId=spuInfo.getId();
        //1.2保存spu的desc信息 spu_infp_desc
        SpuInfoDescEntity spuInfoDescEntity=new SpuInfoDescEntity();
        //spu_info_desc 表的主键是spu_id 需要在实体类中配置该主键不是自增
        spuInfoDescEntity.setSpuId(spuId);
        //把商品的图片描述，保存到spu详情表中，图片地址以逗号分割
        spuInfoDescEntity.setDecript(StringUtils.join(spuInfo.getSpuImages(),","));
        spuInfoDescDao.insert(spuInfoDescEntity);
        //1.3保存spu 的规格参数信息
        List<ProductAttrValueVo> baseAttrs = spuInfo.getBaseAttrs();
        if (!CollectionUtils.isEmpty(baseAttrs)){

            List<ProductAttrValueEntity> collect = baseAttrs.stream().map(productAttrValueVo -> {
                productAttrValueVo.setSpuId(spuId);
                productAttrValueVo.setAttrSort(0);
                productAttrValueVo.setQuickShow(0);
                return productAttrValueVo;
            }).collect(Collectors.toList());
            productAttrValueService.saveBatch(collect);
        }
        //2 保存sku的相关信息
        List<SkuInfoVo> skus = spuInfo.getSkus();
        if (CollectionUtils.isEmpty(skus)){
            return;
        }
        skus.forEach(skuInfoVo -> {
            SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
           //2.1 保存sku的基本信息
            BeanUtils.copyProperties(skuInfoVo,skuInfoEntity);
            //品牌id与分类id需要从spuInfo中取
            skuInfoEntity.setBrandId(spuInfo.getBrandId());
            skuInfoEntity.setCatalogId(spuInfo.getCatalogId());
            //获取随机的uuid作为sku编码
            skuInfoEntity.setSkuCode(UUID.randomUUID().toString().substring(0,10).toUpperCase());
            //获取图片列表
            List<String> images = skuInfoVo.getImages();
            if(!CollectionUtils.isEmpty(images)){
                //将图片列表第一张作为默认图片
                skuInfoEntity.setSkuDefaultImg(skuInfoEntity.getSkuDefaultImg()==null? images.get(0):skuInfoEntity.getSkuDefaultImg());
            }
        skuInfoEntity.setSpuId(spuId);
            skuInfoDao.insert(skuInfoEntity);
            //获取skuid
            Long skuId = skuInfoEntity.getSkuId();
            //2.2保存图片信息
            if(!CollectionUtils.isEmpty(images)){
                String defaultImages=images.get(0);
                List<SkuImagesEntity> skuImagesEntities = images.stream().map(image -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setDefaultImg(StringUtils.equals(image, defaultImages) ? 1 : 0);
                    skuImagesEntity.setImgSort(0);
                    skuImagesEntity.setImgUrl(image);
                    return skuImagesEntity;
                }).collect(Collectors.toList());
            skuImagesService.saveBatch(skuImagesEntities);
            }
            //2.3保存sku销售属性
            List<SkuSaleAttrValueEntity> saleAttrs = skuInfoVo.getSaleAttrs();
            saleAttrs.forEach(saleAttr->{
                saleAttr.setSkuId(skuId);
                saleAttr.setAttrName(attrDao.selectById(saleAttr.getAttrId()).getAttrName());
                saleAttr.setAttrSort(0);
            });
            skuSaleAttrValueService.saveBatch(saleAttrs);

            //3 调用sms
            SkuSaleVo skuSaleVo = new SkuSaleVo();
            BeanUtils.copyProperties(skuInfoVo,skuSaleVo);
            skuSaleVo.setSkuId(skuId);
            smsFeign.saveSkuSaleInfo(skuSaleVo);
        });



    }

}