package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/findOne")
    public @ResponseBody Banner queryOne(String id){
        Banner banner = bannerService.findOneById(id);
        return banner;
    }

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<>();
        //当前页数据rows:
        List<Banner> banners = bannerService.findByPage(page, rows);
        //总记录数
        Long totals = bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }


    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Banner banner,HttpServletRequest request,MultipartFile img) {
        Map<String,Object> results = new HashMap<>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/banner/imgs");
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            banner.setImgPath("/back/banner/imgs/"+img.getOriginalFilename());
            bannerService.add(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Banner banner){
        Map<String,Object> results = new HashMap<>();
        try {
            bannerService.motify(banner);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }


    @RequestMapping("/deleteMore")
    public @ResponseBody Map<String,Object> deleteMore(HttpServletRequest request,String[] id){
        Map<String,Object> results = new HashMap<>();
        try {
            for (String s : id) {
                String realPath = request.getSession().getServletContext().getRealPath("");
                System.out.println("绝对路径======================================"+realPath);
                File file = new File(realPath+bannerService.findOneById(s).getImgPath());
                file.delete();
                bannerService.remove(s);
            }
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
