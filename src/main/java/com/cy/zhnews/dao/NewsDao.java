package com.cy.zhnews.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.zhnews.entity.po.News;
import com.cy.zhnews.entity.vo.IndexObject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsDao extends BaseMapper<News> {

    @Select("select n.eid,n.title,n.tilte_image tilteImage,n.content,n.time,e.essay from news n join news_essay e on n.eid=e.eid")
    List<IndexObject> findAll();

}
