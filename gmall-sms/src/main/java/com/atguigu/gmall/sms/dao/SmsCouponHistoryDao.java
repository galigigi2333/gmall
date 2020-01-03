package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SmsCouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
@Mapper
public interface SmsCouponHistoryDao extends BaseMapper<SmsCouponHistoryEntity> {
	
}
