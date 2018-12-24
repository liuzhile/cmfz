package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> queryAll();
    public Album queryOne(Integer id);
    public void add(Album album);
}
