package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("add")
    public void add(HttpSession session, MultipartFile audio,Chapter chapter, Integer aid) {
        String realPath = session.getServletContext().getRealPath("/album/audio");
        File file = new File(realPath+"/"+audio.getOriginalFilename());
        try {
            audio.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = "/album/audio/"+audio.getOriginalFilename();
        chapter.setUrl(url);
        chapter.setAlbumId(aid);
        long size = audio.getSize();
        chapter.setSize(size/(1000*1000)+"M");
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(file);
            long ls = m.getDuration();
            int min = (int) (ls/1000/60);
            int second = (int) ((ls/1000)%60);
            String duration = min+"分"+second+"秒";
            chapter.setDuration(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        chapterService.add(chapter);
    }
    @RequestMapping(value = "download",produces="text/plain;charset=UTF-8")
    public void download(HttpSession session, String name, HttpServletResponse response) {
        String realPath = session.getServletContext().getRealPath("/album/audio");
        String[] realName = name.split("/");
        byte[] bs ;
        ServletOutputStream out = null;
        try {
            bs = FileUtils.readFileToByteArray(new File(realPath+"/"+realName[3]));
            response.setContentType("audio/mpeg");
            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(realName[3],"UTF-8"));
            out= response.getOutputStream();
            out.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(out!=null) {
                try {
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
