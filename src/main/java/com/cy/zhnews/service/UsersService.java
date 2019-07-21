package com.cy.zhnews.service;

import com.cy.zhnews.entity.po.Users;

public interface UsersService {

    void doRegister(Users users, String phoneCode);

    void doSignIn(String username,String password);

}
