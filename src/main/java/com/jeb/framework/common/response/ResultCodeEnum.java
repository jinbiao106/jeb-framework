package com.jeb.framework.common.response;

public enum ResultCodeEnum {

    SUCCESS("200", "操作成功"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配"),
    NOT_FOUND("404", "未找到该资源"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试"),
    NAME_EXIST("10001", "名称已存在"),
    MINIO_OPERATION_ERROR("20001", "minio操作异常"),
    FEGIN_CLIENT_ERROR("20002", "fegin调用异常"),
    PARAMS_CHECK_FAIL("20003", "参数校验异常"),
    MANAGER_ERROR("001001001", "{MANAGER_ERROR}"),
    PATTERN_FALSE("90001", "参数格式不正确");

    ResultCodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    private String resultCode;

    private String resultMsg;

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public static String replace(final String source, final String replace) {
        return source.replaceFirst("\\{[^}]*\\}", replace);
    }
}