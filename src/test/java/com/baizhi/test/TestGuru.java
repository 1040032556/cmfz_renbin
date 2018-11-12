package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestGuru {
    @Autowired
    private GuruService guruService;
    @Test
    public void add(){
        Guru guru = new Guru();
        guru.setHeadPic("1.jpg");
        guru.setName("李小辉");
        guru.setSex("女");
        guru.setStatus(0);
        guruService.add(guru);
    }
    @Test
    public void update(){
        Guru guru = new Guru();
        guru.setId("3880b8d8-c379-4700-aedd-c59eb9334f4a");
        guru.setHeadPic("1.jpg");
        guru.setName("李小辉");
        guru.setSex("男");
        guru.setStatus(0);
        guruService.motify(guru);
    }
}
