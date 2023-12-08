/*
 *
 *  * ------------------------------------------------------------------
 *  *  Copyright  2020 DtJoy Technology Co.,Ltd. All rights reserved.
 *  *  ------------------------------------------------------------------
 *
 */

package com.jeb.framework.common.exception;


/**
 * 类名:BusinessException
 * 描述:自定义异常
 **/
public class BusinessException extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    /**
     * getter.
     *
     * @return 错误编码
     */
    public String getErrorCode() {
        return errorCode;
    }


    /**
     * setter.
     *
     * @param errorCode 错误编码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * getter.
     *
     * @return 错误描述信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }


    /**
     * setter.
     *
     * @param errorMsg 错误描述信息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
