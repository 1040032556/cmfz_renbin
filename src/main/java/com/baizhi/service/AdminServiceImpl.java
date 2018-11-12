package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public void add(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        adminDao.insert(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin find(Admin admin) {
        return adminDao.query(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findOneById(String id) {

        return adminDao.queryOneById(id);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public List<Admin> findMore() {
        return null;
    }

    @Override
    public List<Admin> findByPage(Integer start, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
