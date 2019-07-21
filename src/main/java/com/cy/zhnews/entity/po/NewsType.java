package com.cy.zhnews.entity.po;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NewsType implements Serializable {

    private int tid;
    private String type;

}
