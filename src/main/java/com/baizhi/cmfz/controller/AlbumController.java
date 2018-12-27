package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
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
    @RequestMapping("export")
    public void exportExcel(HttpServletResponse response,HttpSession session){
        List<Album> albumList = albumService.queryAll();
        String realPath = session.getServletContext().getRealPath("/album/image");
        for (Album album : albumList) {
            String[] str = album.getCoverImg().split("/");
            album.setCoverImg(realPath+"/"+str[3]);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲项目", "专辑模块", "测试"),
                Album.class, albumList);
        try {
            String encode = URLEncoder.encode("album.xls", "UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment;filename="+encode);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("import")
    public void importExcel(MultipartFile file){
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        importParams.setNeedVerfiy(true);
        try {
            ExcelImportResult<Album> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Album.class, importParams);
            List<Album> list = result.getList();
            for (Album album : list) {
                System.out.println(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
