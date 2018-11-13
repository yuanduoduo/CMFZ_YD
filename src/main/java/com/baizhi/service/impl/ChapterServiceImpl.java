package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;
    public void save(Chapter T) {
        T.setId(UUID.randomUUID().toString());
        T.setUploadTime(new Date());
        Jedis jedis = new Jedis("10.211.55.16", 7000);
        jedis.select(0);
        chapterDao.insert(T);
        Album album = new Album();
        album.setId(T.getAlbum_id());
        Album one = albumDao.queryOne(album);
        Long aLong = chapterDao.queryAlbum_id(T.getAlbum_id());
        one.setCount(aLong+"");
        albumDao.update(one);
        jedis.del("com.baizhi.albumService");
    }

    public void motify(Chapter T) {
        chapterDao.update(T);
    }

    public void remove(String id) {
        Jedis jedis = new Jedis("10.211.55.16",7000);
        jedis.select(0);
        Chapter chapter = chapterDao.queryById(id);
        chapterDao.delete(id);

        Album album = new Album();
        album.setId(chapter.getAlbum_id());
        Album one = albumDao.queryOne(album);
        Long aLong = chapterDao.queryAlbum_id(chapter.getAlbum_id());
        one.setCount(aLong.toString());
        albumDao.update(one);

        jedis.del("com.baizhi.albumService");
    }
    public void removeAlbum_id(String id) {
        chapterDao.deleteAlbum_id(id);
    }

    @Override
    public Long findAlbum_id(String id) {
        return chapterDao.queryAlbum_id(id);
    }

    @Override
    public List<Chapter> findAll() {
        return chapterDao.queryAll();
    }

    @Override
    public Chapter findOne(Chapter T) {
        return chapterDao.queryOne(T);
    }

    @Override
    public List<Chapter> findByPage(Integer start, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return chapterDao.queryTotals();
    }

}
