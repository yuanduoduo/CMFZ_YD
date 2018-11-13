package com.baizhi.service.impl;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;

    public void save(Guru T) {
        T.setId(UUID.randomUUID().toString());
        guruDao.insert(T);
    }

    public void motify(Guru T) {
        guruDao.update(T);
    }

    public void remove(String id) {
        guruDao.delete(id);
    }

    public List<Guru> findAll() {
        return guruDao.queryAll();
    }

    public Guru findOne(Guru T) {
        return guruDao.queryOne(T);
    }

    public List<Guru> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Guru> gurus = guruDao.queryByPage(start, rows);
        return gurus;
    }
    public Long findTotals() {
        return guruDao.queryTotals();
    }
}
