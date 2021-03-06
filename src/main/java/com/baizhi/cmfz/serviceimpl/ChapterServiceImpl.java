package com.baizhi.cmfz.serviceimpl;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.entity.Chapter;
import com.baizhi.cmfz.mapper.AlbumMapper;
import com.baizhi.cmfz.mapper.ChapterMapper;
import com.baizhi.cmfz.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private AlbumMapper albumMapper;
    @Override
    public void add(Chapter chapter) {
        chapter.setId(getUUID());
        chapterMapper.insert(chapter);
        Integer albumId = chapter.getAlbumId();
        Album album = albumMapper.selectByPrimaryKey(albumId);
        album.setCount(album.getCount()+1);
        albumMapper.updateByPrimaryKey(album);
    }
    public String getUUID(){
        String code = UUID.randomUUID().toString().replace("-", "");
        return code;
    }
}
