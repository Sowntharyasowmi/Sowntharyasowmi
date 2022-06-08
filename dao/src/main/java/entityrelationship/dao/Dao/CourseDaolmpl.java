package entityrelationship.dao.Dao;

import entityrelationship.dao.Dto.AddStudentCourseDto;
import entityrelationship.dao.entity.Course;
import entityrelationship.dao.entity.Review;
import entityrelationship.dao.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaolmpl implements CourseDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course getById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> find() {
        return (List<Course>) entityManager.createQuery("from course");
    }

    @Override
    public Course addStudent(AddStudentCourseDto addStudentCourseDto) {
        Course course = entityManager.find(Course.class,addStudentCourseDto.getClass());
        //create a graduate object
        Student student = new Student();
        // set the graduate id to graduate object
        student.setId(addStudentCourseDto.getStudent_id());
        //get the course graduate list and add a graduate
        course.getStudents().add(student);
        //save the updated course
        entityManager.persist(course);
        // return the course
        return course;
    }
    @Override
    public Review saveReview(Review review, int course_id) {
        Course course = entityManager.find(Course.class, course_id);
        course.getReviews().add(review);
        entityManager.persist(course);
        return review;
    }
}