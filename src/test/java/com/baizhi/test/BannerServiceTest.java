package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BannerServiceTest extends Basic {
    @Autowired
    private BannerService bannerService;

    @Test
    public void test1() {
        Banner banner = new Banner();
        banner.setId(UUID.randomUUID().toString());
        banner.setTitle("经院转经轮");
        banner.setDescA("经院转经轮");
        banner.setImgPath("cmfz/banner/5.jpg");
        banner.setStatus("y");
        banner.setCreateDate(new Date());
        bannerService.save(banner);
    }

    @Test
    public void test2() {
        List<Banner> all = bannerService.findAll();
        for (Banner banner : all) {
            System.out.println(banner);
        }
    }

    @Test
    public void test3() {
        bannerService.remove("707dc06a-dadc-4f06-92b2-fcde5ac9d58e");
    }

    @Test
    public void test4() {
        Banner banner = new Banner();
        String abc="9bba70af-3c0b-4a70-adb7-10ab1a6e5f75";
        banner.setId(abc);
        banner.setTitle("经院转经轮");
        banner.setDescA("经院转经轮");
        banner.setImgPath("${pageContext.request.contextPath}/cmfz/banner/5.jpg");
        banner.setStatus("y");
        banner.setCreateDate(new Date());
        System.out.println(banner);
        bannerService.motify(banner);
    }
}
