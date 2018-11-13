package com.baizhi.service.impl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
   @Autowired
   private AdminDao adminDao;

    public Admin findOne(Admin admin) {
        return adminDao.queryOne(admin);
    }
    public List<Admin> findByPage(Integer start, Integer rows) {
        return null;
    }
    public Long findTotals() {
        return null;
    }
    public List<Admin> findAll(){
        List<Admin> adminList = adminDao.queryAll();
        return adminList;
    }
    public void save(Admin admin){
        admin.setId(UUID.randomUUID().toString());
        adminDao.insert(admin);
    }
    public void remove(String id){
        adminDao.delete(id);
    }
    public void motify(Admin admin){
        adminDao.update(admin);
    }

    public Admin findSalt(Admin admin) {
        return adminDao.querySalt(admin);
    }
    public Admin findById(String id) {
        return adminDao.queryById(id);
    }
}
