package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String enCode, Admin admin, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute("validationCode");
        if (code.equals(enCode)) {
            System.out.println(admin);
            Admin salt = adminService.findSalt(admin);
            String md2Hex = DigestUtils.md2Hex(admin.getPassword() + salt.getMd5());
            admin.setPassword(md2Hex);
            System.out.println(admin);
            Admin admin1 = adminService.findOne(admin);
            System.out.println(admin1);
            if (admin1 != null && admin1.getPassword().length() > 0 && admin1.getUsername().length() > 0) {
                request.getSession().setAttribute("admin", admin1);
                request.getSession().setAttribute("Login", "Login");
                return "redirect:/cmfz/main/main.jsp";
            } else {
                return "redirect:/cmfz/login/login.jsp";
            }
        } else {
            return "redirect:/cmfz/login/login.jsp";
        }
    }

    @RequestMapping("remove")
    public String remove(HttpServletRequest request) {
        request.getSession().setAttribute("admin", null);
        return "redirect:/cmfz/login/login.jsp";
    }

    @RequestMapping("updatePassword")
    public String updatePassword(Admin admin) {
        String salt = SaltUtils.getSalt(4);
        String md2Hex = DigestUtils.md2Hex(admin.getPassword() + salt);
        admin.setMd5(salt);
        admin.setPassword(md2Hex);
        adminService.motify(admin);
        return "redirect:/cmfz/login/login.jsp";
    }

    @RequestMapping("findById")
    public String findById(String id, HttpServletRequest request) {
        Admin admin = adminService.findById(id);
        request.setAttribute("admin", admin);
        return "login/edit";
    }


}
