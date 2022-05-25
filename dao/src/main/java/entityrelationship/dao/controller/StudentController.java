package entityrelationship.dao.controller;

import entityrelationship.dao.Dto.Studentdto;
import entityrelationship.dao.entity.Passport;
import entityrelationship.dao.entity.Student;
import entityrelationship.dao.service.StudentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentServiceImpl  service;
    @PostMapping("/student")
    public Student createStudent(@RequestBody Studentdto studentdto){
        Student student=new Student();
        student.setName(studentdto.getName());
        Passport passport=new Passport();
        passport.setPassport_number(studentdto.getPassport_number());
        return service.createStudent(student,passport);

    }
    @GetMapping("/student/{id}")
    public Studentdto findById(@PathVariable ("id")int id){
        Student student= service.findById(id);
        Studentdto studentdto=modelMapper.map(student,Studentdto.class);
        return studentdto;}

    @GetMapping("/student")
    public List<Studentdto> findAll() {
        return service.findall().stream().map(student -> modelMapper.map(student, Studentdto.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/student/{id}")
    public void deletebyid(@PathVariable("id") int id) {
        service.deletebyid(id);
    }

}

