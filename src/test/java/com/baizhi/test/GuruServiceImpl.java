package com.baizhi.test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class GuruServiceImpl extends Basic {
    @Autowired
    private GuruService guruService;
    @Test
    public void test1(){
        Guru guru = new Guru();
        guru.setId(UUID.randomUUID().toString());
        guru.setName("huangtao");
        guru.setHeadPic("cmfz/guruImg/6.png");
        guru.setSex("f");
        guruService.save(guru);
    }

    @Test
    public void test2(){
        Guru guru = new Guru();
        guru.setId("5f0fda73-4456-405d-8eef-3d99c155a7c1");
        guru.setName("huangtao");
        guru.setHeadPic("cmfz/guruImg/7.png");
        guru.setSex("f");
        guruService.motify(guru);
    }
    @Test
    public void test3(){
        List<Guru> all = guruService.findAll();
        for (Guru guru : all) {
            System.out.println(guru);
        }
    }
    @Test
    public void test4(){
        Guru guru = new Guru();
        guru.setId("5f0fda73-4456-405d-8eef-3d99c155a7c1");
        Guru one = guruService.findOne(guru);
        System.out.println(one);
    }
    @Test
    public void test5(){
        guruService.remove("5f0fda73-4456-405d-8eef-3d99c155a7c1");
    }
}
