package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.dao.AttrAttrgroupRelationDao;
import com.atguigu.gmall.pms.dao.AttrDao;
import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.vo.AttrGroupVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.pms.dao.AttrGroupDao;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;
import org.springframework.util.CollectionUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;
    @Autowired
    private AttrDao attrDao;
    @Autowired
    private  AttrGroupDao attrGroupDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageVo(page);
    }


    @Override
    public PageVo queryAttrgroup(QueryCondition condition, Long cid) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("catelog_id",cid);
        IPage<AttrGroupEntity>page=page(
                new Query<AttrGroupEntity>().getPage(condition),
                wrapper
        );
        return  new PageVo(page);
    }

    @Override
    public AttrGroupVo queryById(Long gid) {

        AttrGroupVo attrGroupVo = new AttrGroupVo();
        AttrGroupEntity attrGroup = attrGroupDao.selectById(gid);
        BeanUtils.copyProperties(attrGroup,attrGroupVo);


        //查询关联表

        List<AttrAttrgroupRelationEntity> relations = attrAttrgroupRelationDao.selectList(
                                        new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", gid));
        if (CollectionUtils.isEmpty(relations)){
            return attrGroupVo;
        }
        attrGroupVo.setRelations(relations);


        //查询attr表
        List<Long> attrids = relations.stream().map(relation -> relation.getAttrId()).collect(Collectors.toList());
        List<AttrEntity> attrs = attrDao.selectBatchIds(attrids);
        attrGroupVo.setAttrEntities(attrs);

        return attrGroupVo;
    }

    @Override
    public List<AttrGroupVo> queryByCid(Long cid) {

        //根据分类id查询规格参数组信息
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();

        List<AttrGroupEntity> attrgroups = this.list(wrapper.eq("catelog_id", cid));
        //判断是否为空

            List<AttrGroupVo> attrGroupVos = attrgroups.stream().map(attrgroup -> {
                return this.queryById(attrgroup.getAttrGroupId());
            }).collect(Collectors.toList());

        //根据组id查询中间表查询attr表 attr属性
        return attrGroupVos;
    }
}