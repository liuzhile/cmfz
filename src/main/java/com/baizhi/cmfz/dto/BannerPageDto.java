package com.baizhi.cmfz.dto;

import com.baizhi.cmfz.entity.Banner;

import java.io.Serializable;
import java.util.List;

public class BannerPageDto implements Serializable {
    private List<Banner> rows;
    private Integer total;

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
