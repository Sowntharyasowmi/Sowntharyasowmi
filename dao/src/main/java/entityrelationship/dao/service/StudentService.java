package entityrelationship.dao.service;

import entityrelationship.dao.entity.Passport;
import entityrelationship.dao.entity.Student;

import java.util.List;

public interface StudentService {

    public Student createStudent(Student student, Passport passport);
    public Student findById(int id);
    public List<Student> findall();
    public void deletebyid(int id);
}