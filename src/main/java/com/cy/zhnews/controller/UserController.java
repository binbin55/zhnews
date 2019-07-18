package com.cy.zhnews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("doBackgroundIndex")
    public String doBackgroundIndexPage(){
        return "background/index";
    }

//    @RequestMapping("doNewsPage/{path}")
//    public String doPageIndex(@PathVariable("path") String path){
//        return "news/"+path;
//    }

}



