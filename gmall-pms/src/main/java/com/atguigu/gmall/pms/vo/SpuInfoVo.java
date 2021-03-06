package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.ProductAttrValueEntity;
import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import lombok.Data;

import java.util.List;

@Data
public class SpuInfoVo extends SpuInfoEntity {

    private List<String> spuImages;

    private List<ProductAttrValueVo> baseAttrs;

    private List<SkuInfoVo> skus;

}
