package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Common implements Serializable {

    private int cid;
    private Integer good;
    private Integer bad;
    private Date commonTime;
    private String common;
    private String awatar;
    private Integer nid;

}
