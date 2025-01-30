package com.group21.tpw.Service;

import com.group21.tpw.Entity.CourseEntity;

import java.util.List;

public interface CourseService {
    CourseEntity getById(Long id);
    List<CourseEntity> getAllCourses();
    CourseEntity save(CourseEntity course);
    CourseEntity update(CourseEntity course);
    void deleteCourse(Long id);
}
