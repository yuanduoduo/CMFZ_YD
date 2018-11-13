package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("findAll")
    public @ResponseBody
    List<Banner> findAll() {
        List<Banner> banners = bannerService.findAll();
        return banners;
    }

    @RequestMapping("motify")
    public @ResponseBody
    Map<String, Object> motify(MultipartFile imgPathaa, HttpServletRequest request, Banner banner) {
        Map<String, Object> map = new HashMap();
        try {
            if (imgPathaa != null && imgPathaa.getSize() > 0) {
                String fileName = UploadUtil.upload(imgPathaa, request, "bannerImg");
                banner.setImgPath(fileName);
            }
            bannerService.motify(banner);
            map.put("success", true);
            map.put("message", "修改成功！！！");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "修改失败！！！");
        }
        return map;
    }

    @RequestMapping("remove")
    public @ResponseBody
    Map<String, Object> remove(String[] ids, String id) {
        Map<String, Object> map = new HashMap();
        try {
            if (ids == null) {
                bannerService.remove(id);
            } else {
                for (String s : ids) {
                    bannerService.remove(s);
                }
            }
            map.put("success", true);
            map.put("message", "删除成功!!!");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除失败!!!");
        }
        return map;
    }

    @RequestMapping("save")
    public @ResponseBody
    Map<String, Object> save(MultipartFile imgPathaa, HttpServletRequest request, Banner banner) {
        Map<String, Object> map = new HashMap();
        if (banner != null && banner.getTitle().length() != 0) {
            try {
                if (imgPathaa != null && imgPathaa.getSize() > 0) {
                    String fileName = UploadUtil.upload(imgPathaa, request, "bannerImg");
                    banner.setImgPath(fileName);
                }
                bannerService.save(banner);
                map.put("success", true);
                map.put("message", "添加成功!!!");
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "添加失败!!!");
            }
        }else{
            map.put("success", false);
            map.put("message", "添加失败!!!");
        }
        return map;
    }

    @RequestMapping("findOne")
    public @ResponseBody
    Banner findOne(Banner banner) {
        Banner one = bannerService.findOne(banner);
        return one;
    }

}
