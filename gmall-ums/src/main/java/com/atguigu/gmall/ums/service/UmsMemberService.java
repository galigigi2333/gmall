package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.UmsMemberEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 会员
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:31:09
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {

    PageVo queryPage(QueryCondition params);
}

