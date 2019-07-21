package com.cy.zhnews.service;

import com.cy.zhnews.entity.vo.IndexObject;

import java.util.List;
import java.util.Map;

public interface NewsService {

    void insertTitle(Map<String,Object> map);

    List<IndexObject> selectAll();

}
