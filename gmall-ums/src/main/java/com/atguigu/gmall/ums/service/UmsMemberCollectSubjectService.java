package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.UmsMemberCollectSubjectEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 会员收藏的专题活动
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:31:09
 */
public interface UmsMemberCollectSubjectService extends IService<UmsMemberCollectSubjectEntity> {

    PageVo queryPage(QueryCondition params);
}

