package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.model.Student;
import com.javatpoint.repository.StudentRepository;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){ //Method that returns all students
       List<Student> students = new ArrayList<Student>();
       studentRepository.findAll().forEach(student -> students.add(student));
       return students;
    };

    public Student getStudentById(int id){ //Method that returns specific student
      return studentRepository.findById(id).get();
    };

    public void saveOrUpdate(Student student){ //Method that adds or updates(replaces) student
      studentRepository.save(student);
    };

    public void delete(int id){ //Method that deletes specific student
      studentRepository.deleteById(id);
    };

}
