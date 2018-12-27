package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.DataAnalysis;

import java.util.List;
import java.util.Map;

public interface DataService {
    public List<DataAnalysis> showDataMapByMale();
    public List<DataAnalysis> showDataMapByFemale();
    public Map<String,Object> showActiveUser();
}
