package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.sms.entity.SmsSeckillSessionEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 秒杀活动场次
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
public interface SmsSeckillSessionService extends IService<SmsSeckillSessionEntity> {

    PageVo queryPage(QueryCondition params);
}

