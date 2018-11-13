package com.baizhi.test;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterServiceTest extends Basic{
    @Autowired
    private ChapterService chapterService;

    @Test
    public void test1() {
        Chapter chapter = new Chapter();
        chapter.setDownPath("xiazaidizhi");
        chapter.setAlbum_id("4");
        chapter.setDuration("10xiaoshi");
        chapter.setTitle("dabeizou 1");
        chapter.setSize("123kb");
        chapterService.save(chapter);
    }

    @Test
    public void test2() {
        Long album_id = chapterService.findAlbum_id("4");
        System.out.println(album_id);
    }

}
