package com.cy.zhnews.service.impl;

import com.cy.zhnews.dao.NewsEssayDao;
import com.cy.zhnews.entity.po.NewsEssay;
import com.cy.zhnews.entity.vo.EssayObject;
import com.cy.zhnews.service.NewsEssayService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsEssayServiceImpl implements NewsEssayService {

    @Autowired
    private NewsEssayDao newsEssayDao;

    @Override
    public EssayObject findOne(@Param("eid") Integer id) {
        EssayObject newsEssay = newsEssayDao.load(id);
        return newsEssay;
    }
}
