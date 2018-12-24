package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("show")
    public List<Banner> queryAll(Integer page, Integer rows){
        PageHelper.startPage(page,rows,true);
        return bannerService.queryAll();
    }
    @RequestMapping("add")
    public void add(HttpSession session,MultipartFile image,Banner banner) throws IOException {
        String realPath = session.getServletContext().getRealPath("/banner/image");
        File file = new File(realPath+"/"+image.getOriginalFilename());
        image.transferTo(file);
        String imgPath = "/banner/image/"+image.getOriginalFilename();
        banner.setImgPath(imgPath);
        bannerService.add(banner);
    }
    @RequestMapping("update")
    public void update(Banner banner){
        bannerService.update(banner);
    }
    @RequestMapping("delete")
    public void delete(Integer id){
        bannerService.delete(id);
    }
}
