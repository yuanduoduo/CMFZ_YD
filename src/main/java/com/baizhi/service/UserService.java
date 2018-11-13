package com.baizhi.service;

import com.baizhi.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends BaseService<User>{

    @Transactional(propagation = Propagation.SUPPORTS)
    User findUser(User user);
    @Transactional(propagation = Propagation.SUPPORTS)
    User findSalt(User user);
}
