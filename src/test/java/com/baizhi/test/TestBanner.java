package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBanner {
    @Autowired
    private BannerService bannerService;
    @Test
    public void testadd(){
        Banner banner = new Banner();
        banner.setTitle("经院正殿");
        banner.setDes("大");
        banner.setImgPath("/banner1.png");
        banner.setCreate_date(new Date());
        bannerService.add(banner);
    }
    @Test
    public void findAll(){
        List<Banner> byPage = bannerService.findByPage(1, 2);
        System.out.println(byPage);
    }
    @Test
    public void findOne(){
        Banner oneById = bannerService.findOneById("6f09c94a-a492-4e7b-80b9-ed200f7ce46d");
        System.out.println(oneById);
    }
    @Test
    public void up(){
        Banner banner = bannerService.findOneById("5fef39c8-0492-4251-ab3d-41c0671b671e");
        banner.setTitle("经院正殿");
        banner.setDes("大");
        banner.setCreate_date(new Date());
        bannerService.motify(banner);
    }
}
