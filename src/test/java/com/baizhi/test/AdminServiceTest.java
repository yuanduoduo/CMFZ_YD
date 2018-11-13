package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceTest extends Basic {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Admin admin = new Admin();
        admin.setUsername("2462125513");
        admin.setPassword("123456");
        Admin admin1 = adminService.findOne(admin);
        System.out.println(admin1);
    }
    @Test
    public void test2(){
        Admin admin = new Admin();
        String salt = SaltUtils.getSalt(4);
        System.out.println(salt);
        String md2Hex = DigestUtils.md2Hex("123456" + salt);
        admin.setName("yuanduo");
        admin.setId("3");
        admin.setUsername("12345678");
        admin.setPassword(md2Hex);
        admin.setState("y");
        admin.setMd5(salt);
        adminService.save(admin);
    }
    @Test
    public void test3(){
        Admin admin = new Admin();
        admin.setUsername("17771699898");
        Admin salt = adminService.findSalt(admin);
        String md2Hex = DigestUtils.md2Hex("123456" + salt.getMd5());
        admin.setPassword(md2Hex);
        Admin admin1 = adminService.findOne(admin);
        System.out.println(admin1);
    }
}
