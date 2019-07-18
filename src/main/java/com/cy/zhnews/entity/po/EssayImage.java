package com.cy.zhnews.entity.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class EssayImage  implements Serializable {
    private int eiId;
    private String eiImage;
    private Integer order;
    private Integer eid;

}
