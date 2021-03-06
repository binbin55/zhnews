package com.cy.zhnews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
@MapperScan("com.cy.zhnews.dao")
public class ZhnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhnewsApplication.class, args);
    }

}
