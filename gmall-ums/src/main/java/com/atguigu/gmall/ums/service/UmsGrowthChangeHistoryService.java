package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.UmsGrowthChangeHistoryEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 成长值变化历史记录
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:31:09
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

