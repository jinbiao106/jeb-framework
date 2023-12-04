package com.jeb.framework.handle;


import com.jeb.framework.exception.BusinessException;
import com.jeb.framework.response.ResultCodeEnum;
import com.jeb.framework.response.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

/**
 * 类名:GlobalExceptionHandler
 * 描述:控制层异常处理
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultData<?> BusinessException(HttpServletRequest req, BusinessException e) {
        log.error("系统异常:", e);
        return ResultData.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getErrorMsg())
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData<?> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.INTERNAL_SERVER_ERROR.getResultCode())
                .errorMessage(ResultCodeEnum.INTERNAL_SERVER_ERROR.getResultMsg())
                .build();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ResultData<?> exceptionHandler(HttpServletRequest req, IllegalArgumentException e) {
        log.error("非法参数异常:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.INTERNAL_SERVER_ERROR.getResultCode())
                .errorMessage(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData<?> validHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        log.error("参数校验异常:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.PARAMS_CHECK_FAIL.getResultCode())
                .errorMessage(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage())
                .build();
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultData<?> validHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("参数格式异常:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.BODY_NOT_MATCH.getResultCode())
                .errorMessage(ResultCodeEnum.BODY_NOT_MATCH.getResultMsg())
                .build();
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultData<?> validHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
        log.error("请求参数缺失:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.PARAMS_CHECK_FAIL.getResultCode())
                .errorMessage(ResultCodeEnum.PARAMS_CHECK_FAIL.getResultMsg())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResultData<?> validHandler(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
        log.error("参数类型匹配异常:", e);
        return ResultData.builder()
                .errorCode(ResultCodeEnum.PARAMS_CHECK_FAIL.getResultCode())
                .errorMessage(ResultCodeEnum.PARAMS_CHECK_FAIL.getResultMsg())
                .build();
    }
}
