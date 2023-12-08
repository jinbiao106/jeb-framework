/*
 *
 *  * ------------------------------------------------------------------
 *  *  Copyright  2020 DtJoy Technology Co.,Ltd. All rights reserved.
 *  *  ------------------------------------------------------------------
 *
 */

package com.jeb.framework.common.response;

import lombok.Data;

import java.util.List;

/**
 * @author hujinbiao
 */
@Data
public class Page<T> {

    private long current;

    private long pageSize;

    private long total;

    private List<T> list;
}
