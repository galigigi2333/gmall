package com.atguigu.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.wms.entity.WmsFeightTemplateEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 运费模板
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:42:53
 */
public interface WmsFeightTemplateService extends IService<WmsFeightTemplateEntity> {

    PageVo queryPage(QueryCondition params);
}

