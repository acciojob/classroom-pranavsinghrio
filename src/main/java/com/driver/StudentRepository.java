package com.driver;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
@RestController
public class StudentRepository {

    private HashMap<String, Student> hs;
    private HashMap<String, Teacher> ht;
    private HashMap<String, List<String>> hp;


    public StudentRepository(){
        this.hs = new HashMap<String,Student >();
        this.ht = new HashMap<>();
        this.hp = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student stu){
        hs.put(stu.getName(), stu);
    }

    public void saveTeacher(Teacher tea){
       ht.put(tea.getName(), tea);
    }

    public void saveStudentteacherPair(String s, String t){

        //1. Add the movie into Database ---> WRONG bcz I dont have te movie object

        if(hs.containsKey(s)&&ht.containsKey(t)){

            List<String> list = new ArrayList<>();

            if(hp.containsKey(t))
              list = hp.get(t);

            list.add(s);

            hp.put(t,list);

        }

    }

    public Student getStudent(String name){
        return hs.get(name);
    }
    public Teacher getTeacher(String name){
        return ht.get(name);
    }

    public List<String> findstu(String tea){
        List<String>l=new ArrayList<>();
        if(hp.containsKey(tea)) {
            l = hp.get(tea);
        }
        return l;
    }
    public List<String> findAllStudent(){
        return new ArrayList<>(hs.keySet());
    }

    public void deleteTeacher(String t){

        List<String> stu = new ArrayList<String>();
        if(hp.containsKey(t)){
            stu= hp.get(t);
            for(String s: stu){
                if(hs.containsKey(s)){
                    hs.remove(s);
                }
            }

           hp.remove(t);
        }

        //4. Delete the director from directorDb.
        if(ht.containsKey(t)){
           ht.remove(t);
        }
    }

    public void deleteAllTeacher(){

        HashSet<String> stu = new HashSet<String>();
          ht = new HashMap<>();

        for(String t: hp.keySet()){
            for(String s: hp.get(t)){
                stu.add(s);
            }
        }

        for(String s: stu){
            if(hs.containsKey(s)){
               hs.remove(s);
            }
        }

        hp = new HashMap<>();
    }
}
