package com.cy.zhnews.testDAO;

import com.cy.zhnews.dao.NewsDao;
import com.cy.zhnews.dao.NewsEssayDao;
import com.cy.zhnews.entity.po.News;
import com.cy.zhnews.entity.po.NewsEssay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsDaoTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private NewsDao usersMapper;

    @Autowired
    private NewsEssayDao newsEssayDao;

    @Test
    public void testAdd(){
        News news = new News();
        news.setContent("bin");
        int insert = usersMapper.insert(news);
        System.out.println(insert);
    }

    @Test
    public void testin(){
        NewsEssay one = newsEssayDao.findOne();
        System.out.println(one);
    }


}
