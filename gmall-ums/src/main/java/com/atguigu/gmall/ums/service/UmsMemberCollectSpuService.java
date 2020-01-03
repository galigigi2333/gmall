package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.UmsMemberCollectSpuEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 会员收藏的商品
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:31:09
 */
public interface UmsMemberCollectSpuService extends IService<UmsMemberCollectSpuEntity> {

    PageVo queryPage(QueryCondition params);
}

