package com.baizhi.service;

import com.baizhi.entity.Chapter;

public interface ChapterService extends BaseService<Chapter> {
    void removeAlbum_id(String id);
    Long findAlbum_id(String id);
}
