package com.atguigu.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.wms.entity.WmsWareSkuEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品库存
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:42:53
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageVo queryPage(QueryCondition params);
}

