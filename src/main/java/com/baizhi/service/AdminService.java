package com.baizhi.service;

import com.baizhi.entity.Admin;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface AdminService extends BaseService<Admin>{
    @Transactional(propagation = Propagation.SUPPORTS)
    Admin findSalt(Admin T);
    @Transactional(propagation = Propagation.SUPPORTS)
    Admin findById(String id);
}
