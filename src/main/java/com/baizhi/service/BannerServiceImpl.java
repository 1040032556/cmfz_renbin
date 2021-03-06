package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao bannerDao;
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    @Override

    public Banner find(Banner banner) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner findOneById(String id) {
        Banner banner = bannerDao.queryOneById(id);
        return banner;
    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);

    }

    @Override
    public List<Banner> findMore() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Banner> banners = bannerDao.queryByPage(start, rows);
        return banners;
    }

    @Override
    public Long findTotals() {
        Long aLong = bannerDao.queryTotals();
        return aLong;
    }
}
