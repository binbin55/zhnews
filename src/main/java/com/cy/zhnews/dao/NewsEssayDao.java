package com.cy.zhnews.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.zhnews.entity.po.NewsEssay;
import com.cy.zhnews.entity.vo.EssayObject;
import org.apache.ibatis.annotations.Select;

public interface NewsEssayDao extends BaseMapper<NewsEssay> {

    @Select("select * from news_essay order by eid desc limit 0,1")
    NewsEssay findOne();

    @Select("select n.title,n.time,e.essay from news n join news_essay e on n.eid=e.eid where n.eid=#{eid}")
    EssayObject load(Integer id);

}
