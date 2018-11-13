package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuServiceTest extends Basic {
    @Autowired
    private MenuService menuService;
    @Test
    public void test1(){
        List<Menu> all = menuService.findAll();
        for (Menu menu : all) {
            System.out.println(menu);
        }
    }
}
