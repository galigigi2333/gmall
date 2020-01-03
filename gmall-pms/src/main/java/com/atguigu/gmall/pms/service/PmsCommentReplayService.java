package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.PmsCommentReplayEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品评价回复关系
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2019-12-31 13:10:38
 */
public interface PmsCommentReplayService extends IService<PmsCommentReplayEntity> {

    PageVo queryPage(QueryCondition params);
}

