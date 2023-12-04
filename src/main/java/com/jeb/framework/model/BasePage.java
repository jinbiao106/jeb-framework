package com.jeb.framework.model;

//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

@EqualsAndHashCode()
@Data
public class BasePage {

    @Schema(description = "当前页：从1开始", required = true)
    @Range(max = 10000, min = 0, message = "页码非法范围")
    private int current = 1;

    @Schema(description = "每页条数，最大100", required = true)
    @Range(max = 100, min = 0, message = "单页条数非法范围")
    private int pageSize = 20;

}