package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SmsSeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
@Mapper
public interface SmsSeckillSessionDao extends BaseMapper<SmsSeckillSessionEntity> {
	
}
