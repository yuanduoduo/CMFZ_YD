package com.baizhi.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class UploadUtil {
    public static String upload(MultipartFile imgPath, HttpServletRequest request, String fileName) {
        try {
            request.setCharacterEncoding("UTF-8");
            //System.out.println("原始文件名: " + imgPath.getOriginalFilename());
            //获取上传路径  相对路径 files    获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("cmfz/" + fileName);
            System.out.println(realPath);
            imgPath.transferTo(new File(realPath, imgPath.getOriginalFilename()));
            //Thread.currentThread().sleep(5000);
            return "cmfz/" + fileName + "/" + imgPath.getOriginalFilename();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
