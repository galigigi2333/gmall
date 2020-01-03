package com.atguigu.gmall.oms.dao;

import com.atguigu.gmall.oms.entity.OmsOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
@Mapper
public interface OmsOrderDao extends BaseMapper<OmsOrderEntity> {
	
}
