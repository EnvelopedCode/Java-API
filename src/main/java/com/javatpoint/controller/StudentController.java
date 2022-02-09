package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.Student;
import com.javatpoint.service.StudentService;

@RestController //creating Rest Controller
public class StudentController {

     @Autowired //Autowired the StudentService Class
    StudentService studentService;

     @GetMapping("/students")
    private List<Student> getAllStudent(){
        System.out.println("/students GET");
         return studentService.getAllStudent();
     };

     @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id){
         System.out.println("/student/{id} GET");
       return studentService.getStudentById(id);
     };

     @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id){
         System.out.println("/student/{id} DELETE");
       studentService.delete(id);
     };

     @PostMapping("/student")
    private int saveStudent(@RequestBody Student student){
         System.out.println("/student POST"); //The Specific student is sent through the Request Body
       studentService.saveOrUpdate(student); //This method (reference: StudentService) will execute the action
       return student.getId();
     };

}
