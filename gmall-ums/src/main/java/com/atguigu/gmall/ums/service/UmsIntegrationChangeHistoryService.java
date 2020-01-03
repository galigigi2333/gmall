package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.UmsIntegrationChangeHistoryEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 积分变化历史记录
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:31:09
 */
public interface UmsIntegrationChangeHistoryService extends IService<UmsIntegrationChangeHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

