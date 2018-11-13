package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserServiceTest extends Basic{
    @Autowired
    private UserService userServicel;

    @Test
    public void test1() {
        List<User> all = userServicel.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        User user = new User();
        String salt = SaltUtils.getSalt(4);
        System.out.println(salt);
        String md2Hex = DigestUtils.md2Hex("123456" + salt);
        user.setId("123456");
        user.setCity("北京");
        user.setCreateDate(new Date());
        user.setNickName("黄涛仁波切");
        user.setUsername("123456");
        user.setPassword(md2Hex);
        user.setSign("打倒日本帝国主义，中国人名万岁");
        user.setStatus("y");
        user.setGender("男");
        user.setHeadPic("touxiang");
        user.setPhoneNum("10086");
        user.setProvince("北京省");
        user.setSalt(salt);
        userServicel.save(user);
    }

    @Test
    public void test3() {
        User user = new User();
        String salt = SaltUtils.getSalt(4);
        System.out.println(salt);
        String md2Hex = DigestUtils.md2Hex("12345678" + salt);
        user.setId("e1ccbdc5-056c-4842-a8ff-8230db071f17");
        user.setCity("北京");
        user.setCreateDate(new Date());
        user.setNickName("黄涛仁波切");
        user.setUsername("123456");
        user.setPassword(md2Hex);
        user.setSign("打倒日本帝国主义，中国人名万岁");
        user.setStatus("y");
        user.setGender("男");
        user.setHeadPic("touxiang");
        user.setPhoneNum("10086");
        user.setProvince("北京省");
        user.setSalt(salt);
        userServicel.motify(user);
    }

    @Test
    public void test4() {
        userServicel.remove("e1ccbdc5-056c-4842-a8ff-8230db071f17");
    }

    @Test
    public void test5() {
        User user = new User();
        user.setId("e1ccbdc5-056c-4842-a8ff-8230db071f17");
        User one = userServicel.findOne(user);
        System.out.println(one);
    }

    @Test
    public void test6() {
        List<User> byPage = userServicel.findByPage(1, 1);
        for (User user : byPage) {
            System.out.println(user);
        }
    }
}
