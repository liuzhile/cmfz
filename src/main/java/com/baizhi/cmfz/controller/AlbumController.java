package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("show")
    public List<Album> queryAll(){
        return albumService.queryAll();
    }
    @RequestMapping("detail")
    public Album queryOne(Integer id){
        return albumService.queryOne(id);
    }
    @RequestMapping("add")
    public void add(HttpSession session, MultipartFile image,Album album) throws IOException {
        String realPath = session.getServletContext().getRealPath("/album/image");
        File file = new File(realPath+"/"+image.getOriginalFilename());
        image.transferTo(file);
        String imgPath = "/album/image/"+image.getOriginalFilename();
        album.setCoverImg(imgPath);
        albumService.add(album);
    }
}
