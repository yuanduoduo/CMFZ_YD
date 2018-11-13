package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.ReadMp3;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("save")
    public @ResponseBody
    Map<String,Object> save(MultipartFile downPathaa, HttpServletRequest request, Chapter chapter){
        HashMap<String, Object> map = new HashMap<>();
        String chapter1=null;
        String fileName=null;
        if(chapter==null&&chapter.getTitle().length()== 0){
            map.put("success", false);
            map.put("message", "添加失败！！！");
        }else {
            try {
                if (downPathaa != null && downPathaa.getSize() > 0) {
                    chapter1 = UploadUtil.upload(downPathaa, request, "chapter");
                    fileName = chapter1.substring(chapter1.lastIndexOf("/") + 1);
                    chapter.setDownPath(fileName);
                    String file = "/Users/yuanduo/ideacode/CMFZ_YD/target/CMFZ_YD/" + chapter1;
                    String size = ReadMp3.size(file);
                    chapter.setSize(size);
                    synchronized (ReadMp3.read(file)) {
                        String read = ReadMp3.read(file);
                        chapter.setDuration(read);
                    }
                }
                chapterService.save(chapter);

                map.put("success", true);
                map.put("message", "添加成功！！！");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "添加失败！！！");
            }
        }
        return map;
    }
}
