package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/findOne")
    public @ResponseBody Guru queryOne(String id){
        Guru guru = guruService.findOneById(id);
        return guru;
    }

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Guru guru,HttpServletRequest request,MultipartFile img) {
        Map<String,Object> results = new HashMap<>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/guru/imgs");
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            guru.setHeadPic("/back/guru/imgs/"+img.getOriginalFilename());
            guruService.add(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<>();
        //当前页数据rows:
        List<Guru> gurus = guruService.findByPage(page, rows);
        //总记录数
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }

    @RequestMapping("/deleteMore")
    public @ResponseBody Map<String,Object> deleteMore(HttpServletRequest request,String[] id){
        Map<String,Object> results = new HashMap<>();
        try {
            for (String s : id) {
                String realPath = request.getSession().getServletContext().getRealPath("");
                System.out.println("绝对路径======================================"+realPath);
                File file = new File(realPath+guruService.findOneById(s).getHeadPic());
                file.delete();
                guruService.remove(s);
            }
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Guru guru){
        Map<String,Object> results = new HashMap<>();
        try {
            guruService.motify(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
