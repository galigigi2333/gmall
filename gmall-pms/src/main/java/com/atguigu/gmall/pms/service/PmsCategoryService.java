package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsCategoryEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品三级分类
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2019-12-31 13:10:38
 */
public interface PmsCategoryService extends IService<PmsCategoryEntity> {

    PageVo queryPage(QueryCondition params);
}

