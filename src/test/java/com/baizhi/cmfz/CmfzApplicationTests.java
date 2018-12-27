package com.baizhi.cmfz;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.entity.DataAnalysis;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.mapper.AlbumMapper;
import com.baizhi.cmfz.mapper.ChapterMapper;
import com.baizhi.cmfz.mapper.DataMapper;
import com.baizhi.cmfz.mapper.MenuMapper;
import com.baizhi.cmfz.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    BannerService bannerService;
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    DataMapper dataMapper;
    @Test
    public void test1() {
        List<Menu> menus = menuMapper.queryAll();
        for (Menu menu1 : menus) {
            System.out.println(menu1);
        }
    }
    @Test
    public void test2() {
        List<Album> albums = albumMapper.queryAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    @Test
    public void test3() {
        Chapter c = chapterMapper.selectByPrimaryKey("952754162921441aa3aa50bc19043979");
        String[] str = c.getUrl().split("/");
        System.out.println(str[3]);
    }
    @Test
    public void test4() {
        Integer countByRegDate = dataMapper.queryDataCountByRegDate();
        System.out.println(countByRegDate);
    }

}

