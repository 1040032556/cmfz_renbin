package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Guru;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Chapter chapter, HttpServletRequest request, MultipartFile file) {
        Map<String,Object> results = new HashMap<>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/album/files");
            String uuid = UUID.randomUUID().toString() +System.currentTimeMillis()+ file.getOriginalFilename();
            file.transferTo(new File(realPath, uuid));
            DecimalFormat df = new DecimalFormat("######0.00");
            double size = file.getSize() / 1024.0 / 1024.0;
            chapter.setSize(df.format(size)+"M");

            File file1 = new File(realPath, uuid);
            MP3File f = (MP3File)AudioFileIO.read(file1);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            long trackLength = audioHeader.getTrackLength();
            long s=trackLength%60;
            long min=trackLength/60;
            long h=min/60;
            String s1=null;
            String m1=null;
            String h1=null;
            if(h<10){
                h1="0"+h;
            }else{
                h1=h+"";
            }
            if(min<10){
                m1="0"+min;
            }else{
                m1=min+"";
            }
            if(s<10){
                s1="0"+s;
            }else{
                s1=s+"";
            }
            chapter.setDuration(h1+":"+m1+":"+s1);
            chapter.setDownPath("/back/album/files/"+uuid);
            chapterService.add(chapter);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/download")
    public void download(String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("===================fileName=================="+fileName);
        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("===================realPath=================="+realPath);
        /*2以文件输入流读取文件*/
        FileInputStream is=new FileInputStream(new File(realPath,fileName));
        System.out.println(fileName);
        /*2.1设置响应头*/
        response.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName,"utf-8"));
        /*  3获取响应输出流*/
        ServletOutputStream os = response.getOutputStream();
        /*4使用IOUtils工具类*/
        IOUtils.copy(is,os);
        /* 5 关流*/
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
}