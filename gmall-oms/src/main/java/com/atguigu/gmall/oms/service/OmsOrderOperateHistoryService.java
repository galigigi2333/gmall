package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.oms.entity.OmsOrderOperateHistoryEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 订单操作历史记录
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
public interface OmsOrderOperateHistoryService extends IService<OmsOrderOperateHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

