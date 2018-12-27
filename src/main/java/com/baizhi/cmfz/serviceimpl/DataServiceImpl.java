package com.baizhi.cmfz.serviceimpl;

import com.baizhi.cmfz.entity.DataAnalysis;
import com.baizhi.cmfz.mapper.DataMapper;
import com.baizhi.cmfz.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;
    @Override
    public List<DataAnalysis> showDataMapByMale() {
        return dataMapper.queryDataByMale();
    }

    @Override
    public List<DataAnalysis> showDataMapByFemale() {
        return dataMapper.queryDataByFemale();
    }

    @Override
    public Map<String, Object> showActiveUser() {
        Map<String,Object> map = new HashMap<>();
        map.put("intervals",new String []{"近一周","近两周","近三周"});
        int[] counts = {dataMapper.queryDataCountByRegDate(7),dataMapper.queryDataCountByRegDate(14),dataMapper.queryDataCountByRegDate(21)};
        map.put("counts",counts);
        return map;
    }
}
