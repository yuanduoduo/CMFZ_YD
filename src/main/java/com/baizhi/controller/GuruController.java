package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.util.UploadUtil;
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
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("findAll")
    public @ResponseBody List<Guru> findAll(Guru guru){
        List<Guru> all = guruService.findAll();
        return all;
    }
    @RequestMapping("findOne")
    public @ResponseBody Guru findOne(Guru guru){
        Guru one = guruService.findOne(guru);
        return one;
    }
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(MultipartFile headPicaa, HttpServletRequest request, Guru guru) {
        HashMap<String, Object> map = new HashMap<>();
        if (guru != null && guru.getName().length() != 0) {
            try {
                if (headPicaa != null && headPicaa.getSize() > 0) {
                    String fileName = UploadUtil.upload(headPicaa, request, "guruImg");
                    guru.setHeadPic(fileName);
                }
                guruService.save(guru);
                map.put("success", true);
                map.put("message", "修改成功！！！");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "修改失败！！！");
            }
        }else{
            map.put("success", false);
            map.put("message", "修改失败！！！");
        }
        return map;
    }
    @RequestMapping("remove")
    public @ResponseBody Map<String,Object> remove(String[] ids,String id){
        HashMap<String, Object> map = new HashMap<>();
        try {
            if (ids==null) {
                guruService.remove(id);
            } else {
                for (String s : ids) {
                    guruService.remove(s);
                }
            }
            map.put("success",true);
            map.put("message","修改成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改失败！！！");
        }
        return map;
    }
    @RequestMapping("motify")
    public @ResponseBody Map<String,Object> motify(MultipartFile headPicaa, HttpServletRequest request,Guru guru){
        HashMap<String, Object> map = new HashMap<>();
        try {
            if(headPicaa!=null&&headPicaa.getSize()>0){
                String fileName = UploadUtil.upload(headPicaa, request, "guruImg");
                guru.setHeadPic(fileName);
            }
            guruService.motify(guru);
            map.put("success",true);
            map.put("message","修改成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改失败！！！");
        }
        return map;
    }
}
