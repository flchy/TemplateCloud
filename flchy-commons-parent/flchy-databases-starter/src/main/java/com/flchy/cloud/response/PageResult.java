package com.flchy.cloud.response;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nieqs
 * @date 2019/9/29
 * @description 分页实体类
 */
public class PageResult<T>   implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前页总条数")
    private long total;

    @ApiModelProperty("每页显示条数")
    private int size;

    @ApiModelProperty("总页数")
    private int pages;

    @ApiModelProperty("当前页码")
    private int pageNum;
    @ApiModelProperty("数据")
    private List<T> data = new ArrayList<>();

    public PageResult() {
    }

    public PageResult(Page<T> page) {
        this.setData(page.getResult());
        this.setTotal(page.getTotal());
        this.setSize(page.getPageSize());
        this.setPages(page.getPages());
        this.setPageNum(page.getPageNum());
    }
    public PageResult(List<T> list,Page page) {
        this.setData(list);
        this.setTotal(page.getTotal());
        this.setSize(page.getPageSize());
        this.setPages(page.getPages());
        this.setPageNum(page.getPageNum());
    }

    public PageResult(List<T> list,long total,int size, int pages, int pageNum) {
        this.setData(list);
        this.setTotal(total);
        this.setSize(size);
        this.setPages(pages);
        this.setPageNum(pageNum);
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
