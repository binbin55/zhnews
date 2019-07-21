package com.cy.zhnews.controller;

import com.cy.zhnews.entity.po.Users;
import com.cy.zhnews.service.UsersService;
import com.cy.zhnews.util.GetMessageCode;
import com.cy.zhnews.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UsersController {

    @Autowired
    private UsersService userService;

    //注册
    @RequestMapping("register")
    @ResponseBody
    public JsonResult doRegister(HttpSession session,
                                 @RequestParam("regUsername")String username,
                                 @RequestParam("regPassword")String password,
                                 @RequestParam("phone")String phone,
                                 @RequestParam("yzm")String yzm
                                 ) {
        System.out.println("开始处理注册");
        String phoneCode = (String) session.getAttribute("phoneCode");
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setPhone(phone);
        users.setYzm(yzm);
        userService.doRegister(users,phoneCode);
        return new JsonResult("reg ok!");
    }

    //验证码
    @RequestMapping("matches")
    @ResponseBody
    public JsonResult validateCode(String phone, HttpSession session) {
        GetMessageCode.getCode(phone);
        String phoneCode = GetMessageCode.getRandom();
        session.setAttribute("phoneCode", phoneCode);
        System.out.println("验证码:"+phoneCode);
        return new JsonResult("matches ok!");
    }

    //登录
    @RequestMapping("login")
    @ResponseBody
    public JsonResult doSignIn(@RequestParam("login-username") String username,@RequestParam("login-password") String password,HttpSession session) {
        userService.doSignIn(username,password);
        session.setAttribute("username",username);
        return new JsonResult("login ok!");
    }

}



