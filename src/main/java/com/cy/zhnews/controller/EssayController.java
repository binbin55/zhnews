package com.cy.zhnews.controller;

import com.cy.zhnews.entity.po.NewsEssay;
import com.cy.zhnews.entity.vo.EssayObject;
import com.cy.zhnews.service.NewsEssayService;
import com.cy.zhnews.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/essay/")
public class EssayController {

    @Autowired
    private NewsEssayService newsEssayService;

    @RequestMapping("onloadEssay")
    public JsonResult onloadEssay(Integer eid){
        EssayObject one = newsEssayService.findOne(eid);
        return new JsonResult(one);
    }

}
