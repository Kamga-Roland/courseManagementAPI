package com.group21.tpw.ServiceImpl;

import com.group21.tpw.Entity.CourseEntity;
import com.group21.tpw.Repository.CourseRepository;
import com.group21.tpw.Service.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseEntity getById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return List.of();
    }

    @Override
    public CourseEntity save(CourseEntity course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseEntity update(CourseEntity course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
