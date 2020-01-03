package com.atguigu.gmall.oms.dao;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-03 11:44:39
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
