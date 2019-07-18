package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
public class News  implements Serializable {

    private int nid;
    private String title;
    private String tilteImage;
    private String content;
    private Date time;
    private Integer tid;
    private Integer eid;

}
