package pl.ozezl.managment.studentManagementApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ozezl.managment.studentManagementApp.dbFake.StudentRepository;
import pl.ozezl.managment.studentManagementApp.model.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> all() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll()
                .forEach(student -> studentList.add(student));

        return studentList;
    }

    @GetMapping("/students/{id}")
    public Student one(@PathVariable("id") Long id) throws Exception {
        return studentRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    @PostMapping("/students")
    public List<Student> addStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);

        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll()
                .forEach(student -> studentList.add(student));

        return studentList;
    }

    @PutMapping("/students/{id}")
    public Student changeStudent(@PathVariable("id") Long id, @RequestBody Student newStudent) {
        List<Student> newStudentList = new LinkedList<>();
        studentRepository.findAll()
                .forEach(student -> newStudentList.add(student));
        newStudentList.set(id.intValue(), newStudent);

        studentRepository.saveAll(newStudentList);
        return newStudent;
    }

    @DeleteMapping("/students/{id}")
    public List<Student> deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);

        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll()
                .forEach(student -> studentList.add(student));

        return studentList;
    }

}
