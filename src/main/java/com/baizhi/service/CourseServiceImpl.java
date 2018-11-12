package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;
    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString());
        course.setCreate_date(new Date());
        courseDao.insert(course);
    }

    @Override
    public Course find(Course course) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Course findOneById(String id) {
        return courseDao.queryOneById(id);
    }

    @Override
    public void remove(String id) {
        courseDao.delete(id);
    }

    @Override
    public void motify(Course course) {
        courseDao.update(course);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findMore() {
        return courseDao.queryMore();
    }

    @Override
    public List<Course> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
