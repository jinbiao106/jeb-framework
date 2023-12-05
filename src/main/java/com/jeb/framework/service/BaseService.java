package com.jeb.framework.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeb.framework.response.PageParam;

import java.util.List;

/**
 * @Date 2023-12-04 20:34
 * @Author GuYue
 */
public interface BaseService<T,R> {

    default PageInfo<R> page(PageParam<T> param){
        return PageHelper.startPage(param).doSelectPageInfo(()->list(param.getParam()));

    }
    List<R> list(T param);
}
