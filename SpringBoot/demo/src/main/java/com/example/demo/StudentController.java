package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // update a student
    @PutMapping("/{id}")  // PUT request for updating a student
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id)
            .map(student -> {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                return studentRepository.save(student);
            })
            .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    // delete a student
    @DeleteMapping("/{id}")  // DELETE request for removing a student
    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "✅ Student with ID " + id + " deleted successfully!";
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

}
