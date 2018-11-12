package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public void add(Menu menu) {

    }

    @Override
    public Menu find(Menu menu) {
        return null;
    }

    @Override
    public Menu findOneById(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(Menu menu) {

    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findMore() {
        List<Menu> menus = menuDao.queryMore();
        return menus;
    }

    @Override
    public List<Menu> findByPage(Integer start, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
