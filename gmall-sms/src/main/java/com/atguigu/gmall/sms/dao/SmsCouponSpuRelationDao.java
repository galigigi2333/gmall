package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SmsCouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
@Mapper
public interface SmsCouponSpuRelationDao extends BaseMapper<SmsCouponSpuRelationEntity> {
	
}
