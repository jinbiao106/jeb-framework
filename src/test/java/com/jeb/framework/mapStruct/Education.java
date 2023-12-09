package com.jeb.framework.mapStruct;

import lombok.Data;

@Data
public class Education {
    //学位
    private String degreeName;
    // 研究所
    private String institute;
    private Integer yearOfPassing;
}
