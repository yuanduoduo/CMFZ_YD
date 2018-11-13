package com.baizhi.service.impl;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    public void save(Menu T) {

    }

    public void motify(Menu T) {

    }

    public void remove(String id) {

    }

    public List<Menu> findAll() {
        List<Menu> all = menuDao.queryAll();
        return all;
    }

    public Menu findOne(Menu T) {
        return null;
    }


    public List<Menu> findByPage(Integer start, Integer rows) {
        return null;
    }

    public Long findTotals() {
        return null;
    }
}
