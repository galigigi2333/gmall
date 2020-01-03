package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SmsSeckillSkuNoticeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀商品通知订阅
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
@Mapper
public interface SmsSeckillSkuNoticeDao extends BaseMapper<SmsSeckillSkuNoticeEntity> {
	
}
