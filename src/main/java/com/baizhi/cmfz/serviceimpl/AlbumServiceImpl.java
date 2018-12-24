package com.baizhi.cmfz.serviceimpl;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.mapper.AlbumMapper;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;
    @Override
    public List<Album> queryAll() {
        return albumMapper.queryAll();
    }

    @Override
    public Album queryOne(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Album album) {
        albumMapper.insert(album);
    }
}
