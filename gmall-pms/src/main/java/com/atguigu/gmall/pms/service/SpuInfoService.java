package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.SpuInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;


/**
 * spu信息
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-03 11:41:47
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageVo queryPage(QueryCondition params);

   PageVo queryByCidOrKey(QueryCondition condition, Long catId);

    void bigsave(SpuInfoVo spuInfo);
}

