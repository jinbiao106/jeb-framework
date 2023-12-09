package com.jeb.framework.model.domain;

import java.io.Serializable;

import com.jeb.framework.enums.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @TableName jeb_user
 */
@EqualsAndHashCode
@ToString
@Data
public class User implements Serializable {
    /**
     * 
     */

    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String address;

    private SexEnum sex;


    private static final long serialVersionUID = 1L;


}