package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.SaltUtils;
import com.baizhi.util.UploadUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public @ResponseBody
    Map<String, Object> save(MultipartFile userImg, HttpServletRequest request, User user) {
        Map<String, Object> map = new HashMap();
        if (user != null && user.getUsername().length() != 0) {
            try {
                String salt = SaltUtils.getSalt(4);
                String md2Hex = DigestUtils.md2Hex(user.getPassword() + salt);
                user.setSalt(salt);
                user.setPassword(md2Hex);
                if (userImg != null && userImg.getSize() > 0) {
                    String fileName = UploadUtil.upload(userImg, request, "userImg");
                    user.setHeadPic(fileName);
                }
                userService.save(user);
                map.put("success", true);
                map.put("message", "添加成功！！！");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "添加失败！！！");
            }
        }else{
            map.put("success", false);
            map.put("message", "添加失败！！！");
        }
        return map;
    }

    @RequestMapping("motify")
    public @ResponseBody
    Map<String, Object> motify(MultipartFile userImg, HttpServletRequest request, User user) {
        Map<String, Object> map = new HashMap();
        try {
            System.out.println(userImg);
            if (userImg != null && userImg.getSize() > 0) {
                String fileName = UploadUtil.upload(userImg, request, "userImg");
                user.setHeadPic(fileName);
            }
            userService.motify(user);
            map.put("success", true);
            map.put("message", "添加成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "添加失败！！！");
        }
        return map;
    }

    @RequestMapping("remove")
    public @ResponseBody
    Map<String, Object> remove(String[] ids, String id) {
        Map<String, Object> map = new HashMap();
        try {
            if (ids == null) {
                userService.remove(id);
            } else {
                for (String s : ids) {
                    userService.remove(s);
                }
            }
            map.put("success", true);
            map.put("message", "添加成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "添加失败！！！");
        }
        return map;
    }

    @RequestMapping("findAll")
    public @ResponseBody
    List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping("findOne")
    public @ResponseBody
    User findOne(User user) {
        User one = userService.findOne(user);
        return one;
    }

    @RequestMapping("queryByPage")
    public @ResponseBody
    List<User> queryByPage(Integer page, Integer rows) {
        List<User> users = userService.findByPage(page, rows);
        return users;
    }

    @RequestMapping("loginUser")
    public @ResponseBody
    Map<String, Object> loginUser(User user) {
        Map<String, Object> map = new HashMap();
        try {
            System.out.println(user);
            User salt = userService.findSalt(user);
            String s = DigestUtils.md2Hex(user.getPassword() + salt.getSalt());
            user.setPassword(s);
            User user1 = userService.findUser(user);
            if (user1 == null) {
                map.put("success", false);
                map.put("message", "测试登陆失败！！！");
            } else {
                String s1 = JSONObject.toJSONString(user1);
                map.put("success", true);
                map.put("message", "测试登陆成功！！！"+s1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "测试登陆失败！！！");
        }
        return map;
    }
}
