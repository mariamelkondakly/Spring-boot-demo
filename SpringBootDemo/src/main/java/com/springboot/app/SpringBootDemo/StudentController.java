package com.springboot.app.SpringBootDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/Student")
    public Student getStudent(){
        return (new Student("Mariam","Elkondakly"));
    }

    @GetMapping("/Students")
    public List<Student> getAllStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student("Mariam","Elkondakly"));
        students.add(new Student("Mariam","Ibrahim"));
        students.add(new Student("Maya","Tamer"));
        students.add(new Student("Mariam","Mohamed"));
        students.add(new Student("Menna","Mohamed"));
        students.add(new Student("Laila","Sherif"));
        return students;
    }
    @GetMapping("/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        return new Student(firstName,lastName);
    }
    @GetMapping("/student/query")
    public Student StudentQueryParam(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName") String lastName){
        return new Student(firstName,lastName);

    }
}
