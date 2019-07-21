package com.cy.zhnews.testService;

import com.cy.zhnews.entity.po.NewsType;
import com.cy.zhnews.service.NewsTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsTypeTests {

    @Autowired
    private NewsTypeService newsTypeService;

    @Test
    public void contextLoads() {
        List<NewsType> all = newsTypeService.findAll();
        for (NewsType newsType : all){
            System.out.println(newsType);
        }
    }

}
