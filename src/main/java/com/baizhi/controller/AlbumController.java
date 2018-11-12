package com.baizhi.controller;

import com.baizhi.entity.Album;

import com.baizhi.service.AlbumService;
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
import java.util.UUID;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAll")
    public @ResponseBody  List<Album> findAll(){
        List<Album> albums = albumService.findMore();
        return albums;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Album findOne(HttpServletRequest request,String id){
        Album one = albumService.findOneById(id);
        request.getSession().setAttribute("imgsrc",one.getImgPath());
        return one;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String,Object> save(Album album, HttpServletRequest request, MultipartFile img) {
        Map<String,Object> results = new HashMap<>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/album/imgs");
            String uuid = UUID.randomUUID().toString() +System.currentTimeMillis()+ img.getOriginalFilename();
            img.transferTo(new File(realPath,uuid));
            album.setImgPath("/back/album/imgs/"+uuid);
            albumService.add(album);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
