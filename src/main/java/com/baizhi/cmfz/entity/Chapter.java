package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    private String id;
    @Excel(name = "章节标题",width = 20)
    private String title;
    @Excel(name = "音频大小")
    private String size;
    @Excel(name = "音频时长")
    private String duration;
    @Excel(name = "音频路径",width = 20)
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上传时间",format = "yyyy-MM-dd HH:mm:ss",width = 20)
    private Date uploadDate;
    private Integer albumId;
}
