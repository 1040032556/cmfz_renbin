package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.AdminService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestMenu {
    @Autowired
    private MenuService menuService;
    @Test
    public void queryAllMenu(){
        List<Menu> menus = menuService.findMore();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
