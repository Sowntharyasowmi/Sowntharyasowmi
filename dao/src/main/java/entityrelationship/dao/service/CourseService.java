package entityrelationship.dao.service;

import entityrelationship.dao.Dto.AddStudentCourseDto;
import entityrelationship.dao.entity.Course;
import entityrelationship.dao.entity.Review;

import java.util.List;

public interface CourseService  {
    public Course save(Course course);
    public Course getById(int id);
    public List<Course> find();
    public Course addStudent(AddStudentCourseDto addStudentCourseDTO);
    Review addStudent(Review review, int course_id);
}
