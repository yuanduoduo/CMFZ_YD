package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AlbumServiceTest extends Basic {
    @Autowired
    private AlbumService albumService;

    @Test
    public void test1() {
        Album album = new Album();
        album.setAuthor("宋佳伟");
        album.setBrief("很长的简介");
        album.setCoverImg("很帅的图片");
        album.setBroadCast("黄涛师兄");
        album.setCount("0");
        album.setTitle("大悲咒");
        album.setStar("0");
        albumService.save(album);
    }

    @Test
    public void test2() {
        albumService.remove("ac6872bd-7d4e-44e7-882f-dbe6a866af4f");
    }

    @Test
    public void test3() {
        Album album = new Album();
        album.setId("c3a589d0-c644-4b15-9df3-f09305d34474");
        album.setAuthor("宋佳伟");
        album.setBrief("很长的简介");
        album.setCoverImg("很帅的图片");
        album.setBroadCast("黄涛师兄");
        album.setCount("0");
        album.setTitle("大悲咒");
        album.setStar("2");
        album.setPublishDate(new Date());
        albumService.motify(album);
    }

    @Test
    public void test4() {
        List<Album> all = albumService.findAll();
        for (Album album : all) {
            System.out.println(album);
        }
    }

    @Test
    public void test6() {
        Long aLong = albumService.findTotals();
        System.out.println(aLong);
    }

    @Test
    public void test5() {
        List<Album> albums = albumService.findByPage(1, 2);
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    @Test
    public void test7() {
        String salt = SaltUtils.getSalt(4);
        System.out.println(salt);
        String md2Hex = DigestUtils.md2Hex("12345678" + salt);
        System.out.println(md2Hex);

    }
    @Test
    public void test8(){
        List<Album> byPage = albumService.findByPage(1, 2);
        for (Album album : byPage) {
            System.out.println(album);
        }
    }

    @Test
    public void test9() {
        Long totals = albumService.findTotals();
        System.out.println(totals);
    }
}
