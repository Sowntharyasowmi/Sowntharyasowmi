package entityrelationship.dao.service;

import entityrelationship.dao.Dao.StudentDaoImpl;
import entityrelationship.dao.entity.Passport;
import entityrelationship.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDaoImpl studentDao;
    @Override
    public Student createStudent(Student student,Passport passport) {
        return studentDao.save(student,passport);

    }

    @Override
    public Student findById(int id) {

        return studentDao.findById(id);
    }

    @Override
    public List<Student> findall() {
        return studentDao.findAll();
    }

    @Override
    public void deletebyid(int id) {
        studentDao.deletebyid(id);
    }

}