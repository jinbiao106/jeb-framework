package com.jeb.framework.response;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;
import com.jeb.framework.model.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * @author 晴明
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageInfo<T> extends PageSerializable<T> {

    private int current;
    private int pageSize;

    public PageInfo(List<T> list) {
        super(list);
        if (list instanceof Page) {
            Page page = (Page) list;
            this.current = page.getPageNum();
            this.pageSize = page.getPageSize();
        } else {
            this.current = 1;
            this.pageSize = list.size();
        }
    }

    public PageInfo(BasePage page) {
        this.current = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = 0;
        this.list = Collections.emptyList();
    }

    public PageInfo(List<T> data, int current, int pageSize, long total) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
        this.list = data;
    }
}
