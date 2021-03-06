package com.atguigu.gmall.pms.service.impl;


import com.atguigu.gmall.pms.dao.AttrAttrgroupRelationDao;
import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gmall.pms.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.pms.dao.AttrDao;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    private AttrDao attrDao;
    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryAttr( QueryCondition condition,Long cid, Integer type) {
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        if (type!=null){
            wrapper.eq("attr_type",type);
        }
        wrapper.eq("catelog_id",cid);

        IPage<AttrEntity>page=page(
                new Query<AttrEntity>().getPage(condition),
                wrapper
                );


        return new PageVo(page);
    }

    @Override
    @Transactional
    public void saveAttrvo(AttrVo vo) {
         this.save(vo);

        //关联


        AttrAttrgroupRelationEntity relation = new AttrAttrgroupRelationEntity();
        relation.setAttrId(vo.getAttrId());
        relation.setAttrGroupId(vo.getAttrGroupId());
        this.attrAttrgroupRelationDao.insert(relation);

    }


}