package com.baizhi.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BaseService<T> {
  void save(T T);
  void motify(T T);
  void remove(String id);
  @Transactional(propagation = Propagation.SUPPORTS)
  List<T> findAll();
  @Transactional(propagation = Propagation.SUPPORTS)
  T findOne(T T);
  @Transactional(propagation = Propagation.SUPPORTS)
  List<T> findByPage(Integer start,Integer rows);
  @Transactional(propagation = Propagation.SUPPORTS)
  Long findTotals();
}
