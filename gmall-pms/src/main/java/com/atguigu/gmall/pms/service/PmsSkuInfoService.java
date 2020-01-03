package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsSkuInfoEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * sku信息
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2019-12-31 13:10:38
 */
public interface PmsSkuInfoService extends IService<PmsSkuInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

