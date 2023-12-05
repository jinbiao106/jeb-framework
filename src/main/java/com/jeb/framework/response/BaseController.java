package com.jeb.framework.response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {

    public ResultData<?> success() {
        return ResultData.builder()
                .success(true)
                .errorCode(ResultCodeEnum.SUCCESS.getResultCode())
                .errorMessage(ResultCodeEnum.SUCCESS.getResultMsg())
                .build();
    }

    public <T> ResultData<T> success(T data) {
        return new ResultData<T>()
                .setSuccess(true)
                .setErrorCode(ResultCodeEnum.SUCCESS.getResultCode())
                .setErrorMessage(ResultCodeEnum.SUCCESS.getResultMsg())
                .setData(data);
    }

    public <T> ResultData<T> success(T data, String message) {
        return new ResultData<T>()
                .setSuccess(true)
                .setErrorCode(ResultCodeEnum.SUCCESS.getResultCode())
                .setErrorMessage(message)
                .setData(data);
    }

    public <T> ResultData<T> error(String code, String message) {
        return new ResultData<T>()
                .setSuccess(false)
                .setErrorCode(code)
                .setErrorMessage(message);
    }

}