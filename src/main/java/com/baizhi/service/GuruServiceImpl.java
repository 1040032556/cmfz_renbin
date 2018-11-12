package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService{
    @Autowired
    private GuruDao guruDao;

    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru find(Guru guru) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru findOneById(String id) {
        Guru guru = guruDao.queryOneById(id);
        return guru;
    }

    @Override
    public void remove(String id) {
        guruDao.delete(id);
    }

    @Override
    public void motify(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public List<Guru> findMore() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        List<Guru> gurus = guruDao.queryByPage(start, rows);
        return gurus;
    }

    @Override
    public Long findTotals() {
        Long aLong = guruDao.queryTotals();
        return aLong;
    }
}
