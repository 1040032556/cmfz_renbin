package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public @ResponseBody  Map<String,Object> register(User user){
        HashMap<String,Object> map=new HashMap<String,Object>();
        try {
           userService.add(user);
           map.put("success",true);
           map.put("status","200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("status","110");
        }
        return map;
    }

    @RequestMapping("/findUser")
    public @ResponseBody Map<String,Object> login(User user){
        HashMap<String,Object> map=new HashMap<String,Object>();
        try {

            User userLogin = userService.find(user);
            if(userLogin!=null) {
                map.put("success", true);
                map.put("status", "200");
            }else {
                map.put("success",false);
                map.put("status","110");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("status","110");
        }
        return map;
    }

    @RequestMapping("update")
    public @ResponseBody Map<String,Object> updateUser(User user){
        HashMap<String,Object> map=new HashMap<String,Object>();
        try {
            userService.motify(user);
            map.put("success",true);
            map.put("status","200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("status","110");
        }
        return map;
    }
}
