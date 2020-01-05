package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.AttrGroupVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;


/**
 * 属性分组
 *
 * @author Galigigi
 * @email lxf@atguigu.com
 * @date 2020-01-03 11:41:47
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);
    PageVo queryAttrgroup(QueryCondition condition, Long cid);

    AttrGroupVo queryById(Long gid);

    List<AttrGroupVo> queryByCid(Long cid);
}

