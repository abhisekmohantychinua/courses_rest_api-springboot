package com.restapi.courseapi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.restapi.courseapi.dao.CourseRepository;
import com.restapi.courseapi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServices {
    //    static List<Course> courses = new ArrayList<>();
//
//    static {
//        courses.add(new Course(1,"Java","Java Programming"));
//        courses.add(new Course(2,"C++","C++ Programming"));
//        courses.add(new Course(3,"Python","Python Programming"));
//    }
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getCourse(int id) {
//        return courses.stream().filter(course -> course.getId()==id).findFirst().get();
        return courseRepository.findById(id);
    }

    public boolean addCourse(Course course) {
        try {
            courseRepository.save(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCourse(Course course, int id) {
//        AtomicBoolean flag= new AtomicBoolean(false);
//        courses.forEach(course1 -> {
//            if(course1.getId()==id){
//                course1.setName(course.getName());
//                course1.setDetail(course.getDetail());
//                flag.set(true);
//            }
//        });
//        return flag.get();
        course.setId(id);
        courseRepository.save(course);
        return true;
    }

    public void deleteCourse(int id) {
//        courses=courses.stream().filter(course -> course.getId()!=id).collect(Collectors.toList());
        courseRepository.deleteById((Integer) id);
    }
}
