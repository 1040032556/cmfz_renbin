package com.baizhi.test;

import com.baizhi.entity.Admin;
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
public class TestsAdmin {
    @Autowired
    private AdminService adminService;
    @org.junit.Test
    public void saveAdmin(){
        Admin admin = new Admin();
        admin.setName("圆寂");
        admin.setPassword("666666");
        adminService.add(admin);
    }
    @org.junit.Test
    public void queryOneAdmin(){
        Admin admin=new Admin();
        admin.setName("圆寂");
        admin.setPassword("666666");
        Admin admin1 = adminService.find(admin);
        System.out.println(admin1);
    }



}
