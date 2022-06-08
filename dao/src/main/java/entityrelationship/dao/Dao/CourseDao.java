package entityrelationship.dao.Dao;


import entityrelationship.dao.Dto.AddStudentCourseDto;
import entityrelationship.dao.entity.Course;
import entityrelationship.dao.entity.Review;

import javax.persistence.Query;
import java.util.List;

public interface CourseDao {
    public Course save(Course course);
    public Course getById(int course);
    public List<Course> find();

    Course addStudent(AddStudentCourseDto addStudentCourseDto);

    Review saveReview(Review review, int course_id);
}
