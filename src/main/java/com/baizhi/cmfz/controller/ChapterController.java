package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.service.ChapterService;
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
    public void add(HttpSession session, MultipartFile audio,Chapter chapter, Integer aid) throws IOException {
        String realPath = session.getServletContext().getRealPath("/album/audio");
        File file = new File(realPath+"/"+audio.getOriginalFilename());
        audio.transferTo(file);
        String url = "/album/audio/"+audio.getOriginalFilename();
        chapter.setUrl(url);
        chapter.setAlbumId(aid);
        chapterService.add(chapter,aid);
    }
    @RequestMapping(value = "download",produces="text/plain;charset=UTF-8")
    public void download(HttpSession session, String name, HttpServletResponse response) throws IOException {
        String realPath = session.getServletContext().getRealPath("/album/audio");
        String[] realName = name.split("/");
        byte[] bs = FileUtils.readFileToByteArray(new File(realPath+"/"+realName[3]));
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(realName[3],"UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        out.write(bs);
        if(out!=null) out.flush();
        if(out!=null) out.close();
    }
}
