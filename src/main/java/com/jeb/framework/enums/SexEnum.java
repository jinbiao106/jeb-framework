package com.jeb.framework.enums;

/**
 * @Date 2023-12-08 14:04
 * @Author GuYue
 */
public enum SexEnum {
    /**
     * 女
     */
    FEMALE(0, "女"),
    /**
     * 男
     */
    MALE(1, "男");

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static SexEnum getSexEnum(Integer code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode().equals(code)) {
                return sexEnum;
            }
        }
        return null;
    }
    public static String getSexName(Integer code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode().equals(code)) {
                return sexEnum.getName();
            }
        }
        return null;
    }

    public static Integer getSexCode(String name) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getName().equals(name)) {
                return sexEnum.getCode();
            }
        }
        return null;
    }
}
