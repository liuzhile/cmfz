package com.baizhi.cmfz.serviceimpl;

import com.baizhi.cmfz.dto.BannerPageDto;
import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.mapper.BannerMapper;
import com.baizhi.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<Banner> queryAll() {
        return bannerMapper.selectAll();
    }

    @Override
    public void add(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }
}
