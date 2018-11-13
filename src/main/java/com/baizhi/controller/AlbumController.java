package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.DownloadUtil;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("save")
    public @ResponseBody
    Map<String, Object> save(MultipartFile coverImgaa, HttpServletRequest request, Album album) {
        Map<String, Object> map = new HashMap<>();
        if(album!=null&&album.getTitle().length()!=0) {
            try {
                if (coverImgaa != null && coverImgaa.getSize() > 0) {
                    String albumImg = UploadUtil.upload(coverImgaa, request, "albumImg");
                    album.setCoverImg(albumImg);
                }
                albumService.save(album);
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
    Map<String, Object> motify(Album album) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            albumService.motify(album);
            map.put("success", true);
            map.put("message", "修改成功！！！");
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
        HashMap<String, Object> map = new HashMap<>();
        try {
            if(ids==null) {
                if(id.length()>=36){
                    chapterService.remove(id);
                }else{
                    albumService.remove(id);
                    chapterService.removeAlbum_id(id);
                }
            }else{
                for (String s : ids) {
                    if(s.length()==36){
                        chapterService.remove(s);
                    }else{
                        albumService.remove(s);
                        chapterService.removeAlbum_id(s);
                    }
                }
            }
            map.put("success", true);
            map.put("message", "删除成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除失败！！！");
        }
        return map;
    }
    @RequestMapping("findAll")
    public @ResponseBody List<Album> findAll(){
        List<Album> all = albumService.findAll();
        return all;
    }
    @RequestMapping("findByPage")
    public @ResponseBody Map<String,Object> findByPage(Integer page,Integer rows){
        HashMap<String, Object> map = new HashMap<>();
        List<Album> byPage = albumService.findByPage(page, rows);
        Long totals = albumService.findTotals();
        map.put("total", totals);
        map.put("rows", byPage);
        return map;
    }
    @RequestMapping("findOne")
    public @ResponseBody
    Album findOne(Album album){
        if (album.getId().length()<36){
            Album one = albumService.findOne(album);
            System.out.println(album);
            return one;
        }else{
           return null;
        }
    }
    @RequestMapping("/download")
    public void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception{
        DownloadUtil.download(fileName,openStyle,request,response,"chapter");
    }
}
