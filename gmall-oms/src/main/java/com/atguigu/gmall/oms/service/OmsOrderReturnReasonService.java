package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.oms.entity.OmsOrderReturnReasonEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 退货原因
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReasonEntity> {

    PageVo queryPage(QueryCondition params);
}

