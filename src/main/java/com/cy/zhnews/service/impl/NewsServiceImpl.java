package com.cy.zhnews.service.impl;

import com.cy.zhnews.dao.NewsDao;
import com.cy.zhnews.dao.NewsEssayDao;
import com.cy.zhnews.entity.po.News;
import com.cy.zhnews.entity.po.NewsEssay;
import com.cy.zhnews.entity.vo.IndexObject;
import com.cy.zhnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewsEssayDao newsEssayDao;

    @Override
    @Transactional
    public void insertTitle(Map<String,Object> map) {
        NewsEssay newsEssay = new NewsEssay();
        Object essay = map.get("essay");
        newsEssay.setEssay((String) essay);
        newsEssayDao.insert(newsEssay);
        NewsEssay one = newsEssayDao.findOne();
        News news = new News();
        news.setEid(one.getEid());
        news.setContent((String) map.get("content"));
        news.setTitle((String)map.get("title"));
        news.setTime(new Date());
        news.setTid((int)map.get("tid"));
        news.setTilteImage((String)map.get("tilteImage"));
        newsDao.insert(news);
    }

    @Override
    public List<IndexObject> selectAll() {
        final List<IndexObject> all = newsDao.findAll();
        return all;
    }
    
}
