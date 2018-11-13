package com.baizhi.util;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

public class DownloadUtil {
    public static void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/cmfz/"+name);
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath,fileName));
        String userAgent = request.getHeader("User-Agent");
        String formFileName=null;
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            formFileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            formFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        //2.1 设置响应头
        response.setHeader("Content-disposition",String.format(""+openStyle+"; filename=\"%s\"", formFileName));
        response.setCharacterEncoding("UTF-8");
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);
    }
}
