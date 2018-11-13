package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void save(User T) {
        T.setCreateDate(new Date());
        userDao.insert(T);
    }

    public void motify(User T) {
        userDao.update(T);
    }

    public void remove(String id) {
        userDao.delete(id);
    }

    public List<User> findAll() {
        return userDao.queryAll();
    }

    public User findOne(User T) {
        return userDao.queryOne(T);
    }

    public List<User> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<User> users = userDao.queryByPage(start, rows);
        return users;
    }
    public Long findTotals() {
        return userDao.queryTotals();
    }

    @Override
    public User findUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public User findSalt(User user) {
        return userDao.querySalt(user);
    }
}
