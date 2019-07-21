package com.cy.zhnews.service;

import com.cy.zhnews.entity.po.NewsEssay;
import com.cy.zhnews.entity.vo.EssayObject;

public interface NewsEssayService {

    EssayObject findOne(Integer id);

}
