package com.cy.zhnews.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.zhnews.entity.po.Users;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UsersDao extends BaseMapper<Users> {

    //注册用(插入数据)
    void insertUser(Map<String,Object> users);

    //注册用,查询数据库中是否用同名账户
    @Select("select * from users where username=#{username} ")
    Integer findByNameForCheck(String username);
    //登录用,用户名找密码
    @Select("select password from users where username=#{username}")
    String findByName(String username);
    @Select("select salt from users where username=#{username}")
    String findBySalt(String username);

}
