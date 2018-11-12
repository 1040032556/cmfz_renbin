package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
    @Autowired
    private UserService userService;
    @Test
    public void saveU(){
        User user = new User();
        user.setPhone("11111");
        user.setPassword("2");
        userService.add(user);
    }
    @Test
    public void find(){
        User user = new User();
        user.setPhone("11111");
        user.setPassword("2");
        User users= userService.find(user);
        System.out.println(users);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId("63a58f40-6558-4390-9db8-e9b0be6a849f");
        user.setPassword("321");
        userService.motify(user);
    }
}
