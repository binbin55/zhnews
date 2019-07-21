package com.cy.zhnews.testDAO;

import com.cy.zhnews.dao.UsersDao;
import com.cy.zhnews.entity.po.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDao {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void testA(){
//        System.out.println(usersDao);
//        Users users = new Users();
//        users.setSalt();
//        users.setPassword("12");
//        users.setUsername("asd");
//        users.setCreateTime(new Date());
//        users.setModifiedTime(new Date());
//        users.setCreateUser("1");
//        users.setModifiedUser("2");
//        users.setCountNews(0);
//        users.setValid(1);
        Map<String,Object> map = new HashMap<>();
        map.put("salt","12");
        map.put("password","123");
        map.put("username","123");
        map.put("createTime",new Date());
        map.put("createUser","1");
        map.put("modifiedTime",new Date());
        map.put("modifiedUser","2");
        map.put("countNews",0);
        map.put("valid",1);
        usersDao.insertUser(map);
        System.out.println("ok");
    }


}
