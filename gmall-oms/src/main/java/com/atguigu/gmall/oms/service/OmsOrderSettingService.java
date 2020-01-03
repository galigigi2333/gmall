package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.oms.entity.OmsOrderSettingEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 订单配置信息
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageVo queryPage(QueryCondition params);
}

