package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestChapter {
    @Autowired
    private ChapterService chapterService;
    @Test
    public void save(){
        Album album = new Album();
        album.setId("445c4a73-433c-4e65-bd14-38a2822e546b");
        Chapter chapter = new Chapter();
        chapter.setTitle("第一章");
        chapter.setDownPath("/e:/aa");
        chapter.setSize("20M");
        chapter.setDuration("00:03:45");
        chapter.setAlbum(album);
        chapterService.add(chapter);
    }

}
