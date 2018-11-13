package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("save")
    public @ResponseBody
    Map<String,Object> save(Course course){
        Map<String, Object> map = new HashMap<>();
        if(course!=null&&course.getTitle().length()!=0) {
            try {
                courseService.save(course);
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
    @RequestMapping("remove")
    public @ResponseBody
    Map<String,Object> remove(String[] ids,String id){
        Map<String, Object> map = new HashMap<>();
        try {
            if(ids==null){
                courseService.remove(id);
            }else{
                for (String s : ids) {
                    courseService.remove(s);
                }
            }

            map.put("success",true);
            map.put("message","添加成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","添加失败！！！");
        }
        return map;
    }
    @RequestMapping("motify")
    public @ResponseBody
    Map<String,Object> motify(Course course){
        Map<String, Object> map = new HashMap<>();
        try {
            courseService.motify(course);
            map.put("success",true);
            map.put("message","添加成功！！！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","添加失败！！！");
        }
        return map;
    }
    @RequestMapping("findAll")
    public @ResponseBody
    List<Course> findAll(){
        List<Course> all = courseService.findAll();
        return all;
    }
    @RequestMapping("findByPage")
    public @ResponseBody Map<String,Object> findByPage(Integer page,Integer rows){
        Map<String, Object> map = new HashMap<>();
        List<Course> byPage = courseService.findByPage(page, rows);
        Long totals = courseService.findTotals();
        map.put("total",totals);
        map.put("rows",byPage);
        return map;
    }
    @RequestMapping("findOne")
    public @ResponseBody Course findOne(Course course){
        Course one = courseService.findOne(course);
        return one;
    }
}

