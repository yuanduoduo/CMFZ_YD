package com.baizhi.service;

import com.baizhi.entity.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuService extends BaseService<Menu>{
    @Transactional(propagation = Propagation.SUPPORTS)
    List<Menu> findAll();
}
