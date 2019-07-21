package com.cy.zhnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("doBackgroundIndex")
    public String doBackgroundIndexPage(){
        return "background/index";
    }

    @RequestMapping("doNewsPage/{path}")
    public String doPageIndex(@PathVariable("path") String path){
        return "news/"+path;
    }

}
