package com.group21.tpw.Controller;

import com.group21.tpw.Entity.CourseEntity;
import com.group21.tpw.Entity.ModuleEntity;
import com.group21.tpw.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable Long courseId) {
       CourseEntity course = this.courseService.getById(courseId);
       if (course == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(course);
    }

    @PostMapping("/{courseId}/modules")
    public ResponseEntity<CourseEntity> addModuleToCourse(@PathVariable Long courseId, @RequestBody ModuleEntity module) {
        CourseEntity course = this.courseService.getById(courseId);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        course.getModules().add(module);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        List<CourseEntity> courses = this.courseService.getAllCourses();
        if (courses == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity course) {
        CourseEntity createdCourse = this.courseService.save(course);
        return ResponseEntity.ok(createdCourse);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable Long courseId,@RequestBody CourseEntity course) {
        CourseEntity course1 = this.courseService.getById(courseId);
        if (course1 == null) {
            return ResponseEntity.notFound().build();
        }
        CourseEntity updatedCourse = this.courseService.update(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        this.courseService.deleteCourse(courseId);
    }
}
