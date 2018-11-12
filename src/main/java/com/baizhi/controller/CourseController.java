package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("findOne")
    public @ResponseBody Course queryOne(String id){
        Course course = courseService.findOneById(id);
        return course;
    }

    @RequestMapping("save")
    public  @ResponseBody Map<String,Object> saveCourse(Course course){
        HashMap<String,Object> results = new HashMap<>();;
        try {
            courseService.add(course);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("findAll")
    public  @ResponseBody List<Course> findAllCourse(){
        HashMap<String,Object> results = new HashMap<>();;

            List<Course> list = courseService.findMore();
            return list;

    }

    @RequestMapping("update")
    public  @ResponseBody Map<String,Object> updateCourse(Course course){
        HashMap<String,Object> results = new HashMap<>();;
        try {
            courseService.motify(course);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("deleteMore")
    public  @ResponseBody Map<String,Object> deleteCourse(HttpServletRequest request, String[] id){
        HashMap<String,Object> results = new HashMap<>();;
        try {
            for (String s : id) {
                courseService.remove(s);
            }
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
