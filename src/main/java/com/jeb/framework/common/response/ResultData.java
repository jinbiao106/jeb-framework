package com.jeb.framework.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ResultData<T> {

    @Schema(description = "异常编码",  example = "500")
    private String errorCode;
    @Schema(description = "异常描述")
    private String errorMessage;
    @Schema(description = "请求是否成功",  example = "true")
    private boolean success;
    @Schema(description = "返回数据",  example = "{}")
    private T data;
}
