package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@ToString
public class News  implements Serializable {

    private int nid;
    @NotBlank(message = "标题不能为空!")
    private String title;
    private String tilteImage;
    @NotBlank(message = "内容不能为空!")
    private String content;
    private Date time;
    private Integer eid;
    private Integer tid;

}
