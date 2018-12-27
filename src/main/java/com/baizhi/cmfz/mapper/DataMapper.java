package com.baizhi.cmfz.mapper;

import com.baizhi.cmfz.entity.DataAnalysis;

import java.util.List;

public interface DataMapper {
    public List<DataAnalysis> queryDataByMale();
    public List<DataAnalysis> queryDataByFemale();
    public Integer queryDataCountByRegDate(Integer count);
}
