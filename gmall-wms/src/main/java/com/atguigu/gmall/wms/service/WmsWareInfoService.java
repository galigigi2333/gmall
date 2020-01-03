package com.atguigu.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.wms.entity.WmsWareInfoEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 仓库信息
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-02 18:42:53
 */
public interface WmsWareInfoService extends IService<WmsWareInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

