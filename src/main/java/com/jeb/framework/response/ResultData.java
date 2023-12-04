package com.jeb.framework.response;

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

//    @ApiModelProperty("异常编码")
    private String errorCode;
//    @ApiModelProperty("异常描述")
    private String errorMessage;
//    @ApiModelProperty("请求是否成功")
    private boolean success;
//    @ApiModelProperty("反参数据")
    private T data;
}
