package com.baizhi.test;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CourseServiceTest extends Basic {
    @Autowired
    private CourseService courseService;
    @Test
    public void test1() {
        Course course = new Course();
        course.setCreatTime(new Date());
        course.setId("1");
        course.setMarking("abc");
        course.setTitle("huangtaorenboqie");
        courseService.save(course);
    }

    @Test
    public void test2() {
        List<Course> all = courseService.findAll();
        for (Course course : all) {
            System.out.println(course);
        }
    }

    @Test
    public void test3() {
        List<Course> byPage = courseService.findByPage(1, 2);
        for (Course course : byPage) {
            System.out.println(course);
        }
    }

    @Test
    public void test4() {
        Long totals = courseService.findTotals();
        System.out.println(totals);
    }

    @Test
    public void test5() {
        Course course = new Course();
        course.setId("1");
        Course one = courseService.findOne(course);
        System.out.println(one);
    }

    @Test
    public void test6() {
        Course course = new Course();
        course.setCreatTime(new Date());
        course.setId("1");
        course.setMarking("123");
        course.setTitle("huangtaorenboqie");
        courseService.motify(course);
    }

    @Test
    public void test7() {
        courseService.remove("1");
    }
}
