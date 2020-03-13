package com.flchy.cloud.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author nieqs
 * @date 2019/9/29
 * @description 分页基类
 */
@ApiModel("基础分页")
public class PageVo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分页参数:要加载的页面,第一页为1,不传时默认值为1")
    private Integer pageNum = 1;

    @ApiModelProperty("分页参数:每页记录数,不传时默认值为10")
    private int pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
