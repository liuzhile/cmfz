package com.baizhi.cmfz;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.awt.SystemColor.menu;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    MenuMapper menuMapper;
    @Test
    public void test() {
        List<Menu> menus = menuMapper.queryAll();
        for (Menu menu1 : menus) {
            System.out.println(menu1);
        }

    }

}

