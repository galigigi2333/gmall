package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.oms.entity.OmsOrderEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 订单
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageVo queryPage(QueryCondition params);
}

