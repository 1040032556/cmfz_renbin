package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setCreate_date(new Date());
        albumDao.insert(album);
    }

    @Override
    public Album find(Album album) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findOneById(String id) {
        return albumDao.queryOneById(id);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(Album album) {

    }

    @Override
    public List<Album> findMore() {
        List<Album> albums = albumDao.queryMore();
        return albums;
    }

    @Override
    public List<Album> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
