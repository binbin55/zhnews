package com.cy.zhnews.service.impl;

import com.cy.zhnews.dao.NewsTypeDao;
import com.cy.zhnews.entity.po.NewsType;
import com.cy.zhnews.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {

    @Autowired
    private NewsTypeDao newsTypeDao;

    @Override
    public List<NewsType> findAll() {
        List<NewsType> all = newsTypeDao.findAll();
        return all;
    }

}
