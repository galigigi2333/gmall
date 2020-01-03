package com.atguigu.gmall.oms.dao;

import com.atguigu.gmall.oms.entity.OmsOrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 17:03:09
 */
@Mapper
public interface OmsOrderOperateHistoryDao extends BaseMapper<OmsOrderOperateHistoryEntity> {
	
}
