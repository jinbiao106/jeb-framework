package com.jeb.framework.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

@EqualsAndHashCode()
@Data
public class BasePage{

    @Range(max = 10000, min = 0, message = "页码非法范围")
    private int pageNum = 1;

    @Range(max = 100, min = 0, message = "单页条数非法范围")
    private int pageSize = 20;

}