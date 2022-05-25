package entityrelationship.dao.Dao;

import entityrelationship.dao.entity.Passport;
import entityrelationship.dao.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.websocket.Session;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student save(Student student, Passport passport) {
        entityManager.persist(passport);
        student.setPassport(passport);
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student findById(int id) {
//        Session currentSession = entityManager.unwrap(Session.class);
//       Student student = currentSession.get(Student.class, id);
//        return student;
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
//        Session currentSession = entityManager.unwrap(Session.class);
        Query query = (Query)entityManager.createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public Student updateStudentById(Student student) {

        return null;
    }

    @Override
    public void deletebyid(int id) {

    }

//    @Override
//    public void deletebyid(int id) {
//        Session currentSession = entityManager.unwrap(Session.class);
//        Query query = currentSession.createQuery("delete from Student where id=:id");
//        query.setParameter("id", id);
//        query.executeUpdate();

    }
