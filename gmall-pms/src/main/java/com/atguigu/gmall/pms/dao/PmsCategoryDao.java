package com.atguigu.gmall.pms.dao;

import com.atguigu.gmall.pms.entity.PmsCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2019-12-31 13:10:38
 */
@Mapper
public interface PmsCategoryDao extends BaseMapper<PmsCategoryEntity> {
	
}
