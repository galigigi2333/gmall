package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:17:45
 */
@Mapper
public interface SmsHomeSubjectDao extends BaseMapper<SmsHomeSubjectEntity> {
	
}
