package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Users implements Serializable {

    private int uid;
    private String username;
    private String password;
    private String salt;
    private String avatar;
    private String phone;
    private int valid;
    private Integer countNews;
    private Date createTime;
    private Date modifiedTime;
    private String createUser;
    private String modifiedUser;
    private String yzm;

}
