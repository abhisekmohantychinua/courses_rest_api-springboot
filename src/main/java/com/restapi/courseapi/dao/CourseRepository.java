package com.restapi.courseapi.dao;

import com.restapi.courseapi.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    public Course findById(int id);
}
