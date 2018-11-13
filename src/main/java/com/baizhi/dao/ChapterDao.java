package com.baizhi.dao;

import com.baizhi.entity.Chapter;

public interface ChapterDao extends BaseDao<Chapter> {
    void deleteAlbum_id(String id);
    Long queryAlbum_id(String id);
}
