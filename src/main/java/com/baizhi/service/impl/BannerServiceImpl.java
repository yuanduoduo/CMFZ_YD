package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;


    public void save(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    public void remove(String id) {
        bannerDao.delete(id);
    }

    public List<Banner> findAll() {
        List<Banner> banners = bannerDao.queryAll();
        return banners;
    }

    public Banner findOne(Banner T) {
        Banner banner = bannerDao.queryOne(T);
        return banner;
    }
    public List<Banner> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Banner> banners = bannerDao.queryByPage(start, rows);
        return banners;
    }
    public Long findTotals() {
        Long totals = bannerDao.queryTotals();
        return totals;
    }
}
