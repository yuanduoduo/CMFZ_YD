package com.baizhi.service.impl;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public void save(Course T) {
        T.setId(UUID.randomUUID().toString());
        courseDao.insert(T);
    }

    @Override
    public void motify(Course T) {
        courseDao.update(T);
    }

    @Override
    public void remove(String id) {
        courseDao.delete(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.queryAll();
    }

    @Override
    public Course findOne(Course T) {
        return courseDao.queryOne(T);
    }

    @Override
    public List<Course> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return courseDao.queryByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return courseDao.queryTotals();
    }
}
