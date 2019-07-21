package com.cy.zhnews.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.zhnews.entity.po.NewsType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsTypeDao extends BaseMapper<NewsType> {

    @Select("select tid,type from news_type")
    List<NewsType> findAll();

}
