package com.cy.zhnews.service.impl;

import com.cy.zhnews.dao.UsersDao;
import com.cy.zhnews.entity.po.Users;
import com.cy.zhnews.service.UsersService;
import com.cy.zhnews.service.ex.ServiceException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    //注册
    @Override
    public void doRegister(Users users, String phoneCode) {

        if(users==null)
            throw new IllegalArgumentException("注册对象不能为空");
        // 必须以字母开头只能包括 字母 , 下划线 , 数字长度必须在6 到 10 之间
        String username = users.getUsername();
        String regex="[a-zA-Z]\\w{3,9}";
        if(!username.matches(regex)){
            throw new ServiceException("用户名格式错误!");
        }
        String regexPsd = "^[a-zA-Z0-9]+$";
        String password = users.getPassword();

        if(!password.matches(regexPsd)){
            throw new ServiceException("密码格式错误!");
        }

//        判断验证码与短信验证码
        String yzm = users.getYzm();
        if(yzm.equals(phoneCode)) {
            String salt= UUID.randomUUID().toString();
            SimpleHash sh=new SimpleHash("MD5",users.getPassword(), salt, 1);
//            users.setSalt(salt);
//            users.setPassword(sh.toHex());
//            users.setCreateTime(new Date());
//            users.setModifiedTime(new Date());
//            users.setCreateUser(username);
//            users.setModifiedUser(username);
//            users.setCountNews(0);
//            users.setValid(1);
            Map<String,Object> map = new HashMap<>();
            map.put("salt",salt);
            map.put("username",username);
            map.put("password",sh.toHex());
            map.put("createTime",new Date());
            map.put("modifiedTime",new Date());
            map.put("createUser",username);
            map.put("modifiedUser",username);
            map.put("countNews",0);
            map.put("valid",1);
            map.put("yzm",yzm);
            map.put("phone",users.getPhone());
            usersDao.insertUser(map);
        }else{
           throw new ServiceException("输入验证码有误!");
        }
    }


    //登录
    @Override
    public void doSignIn(String username, String password) {
        //判断时候存在该用户
        Integer rows = usersDao.findByNameForCheck(username);
        if(rows==0||rows==null) {
            throw new IllegalArgumentException("没有该用户");
        }
        String psw = usersDao.findByName(username);
        String salt = usersDao.findBySalt(username);
        SimpleHash sh=new SimpleHash("MD5",password, salt, 1);
        if(!psw.equals(sh.toHex())) {
            throw new IllegalArgumentException("密码不正确");
        }
    }

}
