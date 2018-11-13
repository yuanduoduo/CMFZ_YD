package com.baizhi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ChapterService chapterService;
    public void save(Album T) {
        Jedis jedis = new Jedis("10.211.55.16",7000);
        jedis.select(0);
        T.setPublishDate(new Date());
        T.setCount("0");
        albumDao.insert(T);
        jedis.del("com.baizhi.albumService");
    }

    public void motify(Album T) {
        Jedis jedis = new Jedis("10.211.55.16",7000);
        jedis.select(0);
        Long totals = chapterService.findTotals();
        T.setCount(totals+"");
        albumDao.update(T);
        jedis.del("com.baizhi.albumService");
    }

    public void remove(String id) {
        Jedis jedis = new Jedis("10.211.55.16",7000);
        jedis.select(0);
        albumDao.delete(id);
        jedis.del("com.baizhi.albumService");
    }

    public List<Album> findAll() {
        Jedis jedis = null;
        List<Album> albumList=null;

        try {
            jedis = new Jedis("10.211.55.16",7000);
            jedis.select(0);
            String keys="findAll"+"Album";
            Boolean hexists = jedis.hexists("com.baizhi.albumService", keys);

            if (hexists) {
                String hget = jedis.hget("com.baizhi.albumService", keys);
                albumList = JSONObject.parseArray(hget,Album.class);
            } else {
                albumList = albumDao.queryAll();
                String json = JSONObject.toJSONString(albumList);
                jedis.hset("com.baizhi.albumService",keys,json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumList;
    }

    public Album findOne(Album T) {
        return albumDao.queryOne(T);
    }

    public List<Album> findByPage(Integer page, Integer rows) {
        System.out.println(page);
        System.out.println(rows);
        Jedis jedis = null;
        List<Album> albumList=null;
        try {
            jedis = new Jedis("10.211.55.16",7000);
            jedis.select(0);
            String keys = "album"+page+"-"+rows;
            Boolean hexists = jedis.hexists("com.baizhi.albumService", keys);
            if(hexists){
                String hget = jedis.hget("com.baizhi.albumService", keys);
                albumList = JSONObject.parseArray(hget, Album.class);
            }else{
                int start=(page-1)*rows;
                albumList=albumDao.queryByPage(start,rows);
                String json = JSONObject.toJSONString(albumList);
                jedis.hset("com.baizhi.albumService", keys,json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumList;
    }


    public Long findTotals() {
        Jedis jedis=null;
        Long total=null;

        try {
            jedis=new Jedis("10.211.55.16",7000);
            jedis.select(0);
            Boolean findTotals = jedis.hexists("com.baizhi.albumService", "findTotals");
            if(findTotals){
                String totals = jedis.hget("com.baizhi.albumService", "findTotals");
                total=Long.parseLong(totals);
            }else{
                total=albumDao.queryTotals();
                String json=total.toString();
                //String json = JSONObject.toJSONString(total);
                jedis.hset("com.baizhi.albumService","findTotals",json);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
