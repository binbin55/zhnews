package com.cy.zhnews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("==addInterceptors==");
        registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/doNewsPage/release");
    }

}
