package com.restapi.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restapi.courseapi.entity.Course;
import com.restapi.courseapi.services.CourseServices;

@RestController
public class MainController {
    @Autowired
    private CourseServices courseServices;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourses() {
        try {
            return ResponseEntity.ok(courseServices.getAllCourses());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourse(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(courseServices.getCourse(id));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<String> saveCourse(@RequestBody Course course){
        if (courseServices.addCourse(course)){
            return ResponseEntity.ok("Your Course is saved");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error occured");
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course,@PathVariable("id") int id){
        if(courseServices.updateCourse(course,id)){
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
        try {
            courseServices.deleteCourse(id);
            return ResponseEntity.ok("Deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some internall error occured");
        }
    }

}
