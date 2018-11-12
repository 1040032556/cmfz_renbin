package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //管理员登陆
    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request,String enCode){
        Admin loginadmins = adminService.find(admin);
        String code = (String) request.getSession().getAttribute("code");

        if(enCode.equals(code)) {
            if (loginadmins != null) {
                request.getSession().setAttribute("login", loginadmins);
                return "redirect:/back/main/main.jsp";
            } else {
                return "redirect:/back/login.jsp";
            }
        }else{
            return "redirect:/back/login.jsp";
        }
    }
    //修改密码
    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(String password,HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            Admin admin = (Admin) request.getSession().getAttribute("login");
            admin.setPassword(password);
            adminService.motify(admin);
            request.getSession().setAttribute("login",null);
            results.put("success",true);

        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    //管理员退出
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("login",null);
        return "redirect:/back/login.jsp";
    }
}
