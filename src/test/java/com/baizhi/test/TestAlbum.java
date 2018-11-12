package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestAlbum {
    @Autowired
    private AlbumService albumService;
    @Test
    public void save(){

        Album album = new Album();
        album.setTitle("范特西");
        album.setAuthor("jay");
        album.setStar(5);
        album.setBrief("RAP&现代");
        album.setBroadcast("jay");
        album.setImgPath("/e:/cc");
        album.setCount(1);
        albumService.add(album);
    }
    @Test
    public void find(){
        List<Album> list = albumService.findMore();
        for (Album album : list) {
            System.out.println(list);
        }
    }
    @Test
    public void findone(){
        Album oneById = albumService.findOneById("66a8cdca-04ba-45dd-b56e-ff7ca01aa8f0");

            System.out.println(oneById);

    }
}
