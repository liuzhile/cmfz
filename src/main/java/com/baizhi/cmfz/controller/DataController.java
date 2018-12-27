package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.DataAnalysis;
import com.baizhi.cmfz.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;
    @RequestMapping("showDataMapByMale")
    public List<DataAnalysis> showDataMapByMale(){
        return dataService.showDataMapByMale();
    }
    @RequestMapping("showDataMapByFemale")
    public List<DataAnalysis> showDataMapByFemale(){
        return dataService.showDataMapByFemale();
    }
    @RequestMapping("showActiveUser")
    public Map<String, Object> showActiveUser(){
        return dataService.showActiveUser();
    }
}
