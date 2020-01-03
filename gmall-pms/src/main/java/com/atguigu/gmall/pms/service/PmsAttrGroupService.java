package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsAttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 属性分组
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2019-12-31 13:10:38
 */
public interface PmsAttrGroupService extends IService<PmsAttrGroupEntity> {

    PageVo queryPage(QueryCondition params);
}

