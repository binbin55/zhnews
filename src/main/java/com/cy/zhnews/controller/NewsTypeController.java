package com.cy.zhnews.controller;

import com.cy.zhnews.entity.po.NewsType;
import com.cy.zhnews.service.NewsTypeService;
import com.cy.zhnews.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/newsType/")
public class NewsTypeController {

    @Autowired
    private NewsTypeService newsTypeService;

    @RequestMapping("findAll")
    public JsonResult findAll(){
        List<NewsType> all = newsTypeService.findAll();
        return new JsonResult(all);
    }

}
