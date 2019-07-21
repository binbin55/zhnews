package com.cy.zhnews.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页试图对象
 */
@Data
@ToString
public class IndexObject implements Serializable {

    private String title;
    private String tilteImage;
    private String content;
    private Date time;
    private Integer eid;
    private String essay;

}
