package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
@ExcelTarget("album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "专辑编号",needMerge = true)
    private Integer id;
    @Excel(name = "专辑标题",width = 20,needMerge = true)
    private String title;
    @Excel(name = "专辑数量",needMerge = true)
    private Integer count;
    @Excel(name = "专辑封面",type = 2 ,width = 20 , height = 40,needMerge = true)
    private String coverImg;
    @Excel(name = "专辑评分",needMerge = true)
    private Integer score;
    @Excel(name = "专辑作者",width = 20,needMerge = true)
    private String author;
    @Excel(name = "专辑播音员",width = 20,needMerge = true)
    private String broadcast;
    @Excel(name = "专辑简介",needMerge = true)
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "专辑发布时间",format = "yyyy-MM-dd HH:mm:ss",width = 20,needMerge = true)
    private Date pubDate;
    @Transient
    @ExcelCollection(name="章节")
    private List<Chapter> children;
}
