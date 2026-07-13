package com.durga.studentmanagement.service;

import com.durga.studentmanagement.entity.Student;
import com.durga.studentmanagement.exception.StudentNotFoundException;
import com.durga.studentmanagement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    // GET all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // GET student by ID
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(id));
        // orElseThrow means:
        // if student found → return it
        // if NOT found    → throw your custom exception (404!)
    }

    // CREATE new student
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    // UPDATE existing student
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id); // reuse above method

        // update only the fields
        existing.setStudentName(updatedStudent.getStudentName());
        existing.setDob(updatedStudent.getDob());
        existing.setBloodGroup(updatedStudent.getBloodGroup());
        existing.setParentPhone(updatedStudent.getParentPhone());
        existing.setFatherName(updatedStudent.getFatherName());
        existing.setMotherName(updatedStudent.getMotherName());

        return studentRepo.save(existing); // save updated version
    }

    // DELETE student
    public void deleteStudent(Long id) {
        Student existing = getStudentById(id); // check exists first
        studentRepo.delete(existing);
    }
}