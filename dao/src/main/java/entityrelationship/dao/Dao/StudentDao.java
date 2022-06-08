package entityrelationship.dao.Dao;

import entityrelationship.dao.entity.Passport;
import entityrelationship.dao.entity.Student;

import java.util.List;

public interface StudentDao {
    public Student save(Student student, Passport passport);
    public Student findById(int id);
    public List<Student> findAll();
    Student updateStudentById(Student student);
    public  void deletebyid(int id);
}