package com.cy.zhnews.testController;

import com.cy.zhnews.controller.EssayController;
import com.cy.zhnews.controller.NewsController;
import com.cy.zhnews.controller.UsersController;
import com.cy.zhnews.util.JsonResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.IOException;
import java.util.Enumeration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsTests {

    @Autowired
    private NewsController newsController;

    @Test
    public void contextLoads() throws IOException {
//        JsonResult jsonResult = newsController.insertTitle(null,null,null,0,null);
//        System.out.println(jsonResult);
    }

    @Test
    public void c(){
        JsonResult allObject = newsController.findAllObject();
        Object data = allObject.getData();
        System.out.println(data);
    }

    @Autowired
    private EssayController essayController;

    @Test
    public void test(){
        JsonResult jsonResult = essayController.onloadEssay(59);
        System.out.println(jsonResult.getData());
    }

    @Autowired
    private UsersController userController;

    @Test
    public void tests(){
        String regUsername = "binbin";
        String regPassword = "binbin";
        String phone = "15113186427";
        String yzm = "555555";
        HttpSession session = new HttpSession() {
            @Override
            public long getCreationTime() {
                return 0;
            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public long getLastAccessedTime() {
                return 0;
            }

            @Override
            public ServletContext getServletContext() {
                return null;
            }

            @Override
            public void setMaxInactiveInterval(int i) {

            }

            @Override
            public int getMaxInactiveInterval() {
                return 0;
            }

            @Override
            public HttpSessionContext getSessionContext() {
                return null;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Object getValue(String s) {
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;
            }

            @Override
            public String[] getValueNames() {
                return new String[0];
            }

            @Override
            public void setAttribute(String s, Object o) {

            }

            @Override
            public void putValue(String s, Object o) {

            }

            @Override
            public void removeAttribute(String s) {

            }

            @Override
            public void removeValue(String s) {

            }

            @Override
            public void invalidate() {

            }

            @Override
            public boolean isNew() {
                return false;
            }
        };
//        JsonResult jsonResult = userController.doRegister(regUsername, regPassword, phone, yzm, session);
//        System.out.println(jsonResult.getData());
    }

}
