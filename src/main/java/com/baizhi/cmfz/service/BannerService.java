package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAll();
    public void add(Banner banner);
    public void update(Banner banner);
    public void delete(Integer id);
}
