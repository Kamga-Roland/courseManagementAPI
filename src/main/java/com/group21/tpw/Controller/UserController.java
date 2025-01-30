package com.group21.tpw.Controller;

import com.group21.tpw.Entity.CourseEntity;
import com.group21.tpw.Entity.UserEntity;
import com.group21.tpw.Service.CourseService;
import com.group21.tpw.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CourseService courseService;

    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId) {
        UserEntity user = userService.getById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/courses")
    public ResponseEntity<UserEntity> addCourseToUser(@PathVariable Long userId, @RequestBody CourseEntity course) {
        UserEntity user = userService.getById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.getCourses().add(course);
        course.getUsers().add(user);
        courseService.save(course);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long userId, @RequestBody UserEntity user) {
        UserEntity user1 = userService.getById(userId);
        if (user1 == null) {
            return ResponseEntity.notFound().build();
        }
        UserEntity savedUser = userService.update(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


}
