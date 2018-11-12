package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User find(User user) {
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        User query = userDao.query(user);
        return query;
    }

    @Override
    public User findOneById(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(User user) {
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userDao.update(user);
    }

    @Override
    public List<User> findMore() {
        return null;
    }

    @Override
    public List<User> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
