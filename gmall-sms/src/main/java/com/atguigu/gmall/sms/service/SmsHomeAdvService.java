package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SmsHomeAdvEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 首页轮播广告
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
public interface SmsHomeAdvService extends IService<SmsHomeAdvEntity> {

    PageVo queryPage(QueryCondition params);
}

