package com.jeb.framework.model.dto.user;


import com.jeb.framework.model.BasePage;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * 
 * @TableName jeb_user
 */
@Data
public class UserRespDTO extends BasePage implements Serializable {

    @NotNull(message = "用户名不能为空")
    @Schema(description = "用户名", required = true, example = "小明")
    private String name;

    @Range(min = 10,max = 100)
    @Schema(description = "年龄", minimum = "1",maximum = "200", example = "10")
    private Integer age;

    @Schema(description = "地址", maxLength = 30, example = "10")
    private String address;

    @Schema(description = "性别", maxLength = 2, example = "01")
    private Integer sex;
    private static final long serialVersionUID = 1L;


}