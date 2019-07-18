package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NewsEssay implements Serializable {

    private int eid;
    private String essay;
    private Integer eiId;

}
