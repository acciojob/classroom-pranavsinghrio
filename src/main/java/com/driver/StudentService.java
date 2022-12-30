package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student s){
       studentRepository.saveStudent(s);
    }

    public void addTeacher(Teacher t){
       studentRepository.saveTeacher(t);
    }

    public void createStudenttecherPair(String s, String t){
      studentRepository.saveStudentteacherPair(s,t);
    }

    public Student findStu(String name){
      return studentRepository.getStudent(name);
    }

    public Teacher findTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public List<String> findstuFromTeacher(String t){
        return studentRepository.findstu(t);
    }

    public List<String> findAllStu(){
        return studentRepository.findAllStudent();
    }

    public void deleteTeacher(String t){
        studentRepository.deleteTeacher(t);
    }

    public void deleteAllTeachers(){
       studentRepository.deleteAllTeacher();
    }
}

