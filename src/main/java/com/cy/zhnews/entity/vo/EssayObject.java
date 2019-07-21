package com.cy.zhnews.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class EssayObject {

    private String title;
    private Date time;
    private String essay;

}
