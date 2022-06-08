package entityrelationship.dao.service;

import entityrelationship.dao.Dao.CourseDaolmpl;
import entityrelationship.dao.Dto.AddStudentCourseDto;
import entityrelationship.dao.entity.Course;
import entityrelationship.dao.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDaolmpl CourseDao;

    @Override
    public Course save(Course course) {
        return CourseDao.save(course);
    }

    @Override
    public Course getById(int id) {

        return CourseDao.getById(id);

    }


    @Override
    public List<Course> find() {
        return CourseDao.find();

    }



    @Override
    public Course addStudent(AddStudentCourseDto addStudentCourseDto) {
        return addStudent(addStudentCourseDto);
    }
    @Override
    public Review addStudent(Review review, int course_id) {

        return CourseDao.saveReview(review, course_id);
    }
}
