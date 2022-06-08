package entityrelationship.dao.controller;

import entityrelationship.dao.Dto.AddReviewDto;
import entityrelationship.dao.Dto.AddStudentCourseDto;
import entityrelationship.dao.Dto.CourseDto;
import entityrelationship.dao.entity.Course;
import entityrelationship.dao.entity.Review;
import entityrelationship.dao.service.CourseService;
import org.modelmapper.ModelMapper;
import entityrelationship.dao.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static entityrelationship.dao.Dto.CourseDto.*;


@RestController
public class CourseController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseServiceImpl service;

    @PostMapping("/course")
    public CourseDto addCourse(@RequestBody CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        course = service.save(course);
        return modelMapper.map(course, CourseDto.class);
    }

    @GetMapping("/course/{id}")
    public CourseDto getById(@PathVariable("id") int id) {
        Course course = service.getById(id);
        CourseDto courseDto = modelMapper.map(course, CourseDto.class);
        return courseDto;

    }

    @GetMapping("/course")
    public List<Course>findall(){
        return service.find();}

    @PostMapping("/course/add/review")
    public Review addStudent(@RequestBody AddReviewDto addReviewDto){
        Review review = new Review(addReviewDto.getRating(), addReviewDto.getComment());
        return service.addStudent(review, addReviewDto.getCourse_id());
    }
}
