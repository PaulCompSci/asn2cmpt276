package com.cmpt276.asn2cmpt276.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmpt276.asn2cmpt276.model.Student;
import com.cmpt276.asn2cmpt276.model.StudentRepo;

import jakarta.servlet.http.HttpServletResponse;







@Controller 
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;
    

    // @GetMapping("/student/view") 
    // public String  getAllStudent (Model model) { 

    //     System.out.println("getting all users");
    //     List<Student> student = studentRepo.findAll() ; 

    //     model.addAttribute("student" , student) ; 

    //     return "student/showAll";
    // }

    @PostMapping ("/student/add")  // adding student to db
    public String addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response){ 

        System.out.println("ADD USER" ) ;
        String newName  = newStudent.get("name") ; 
        System.out.println("testing code");
        System.out.println(newName);
        Double newWeight = Double.parseDouble(newStudent.get("weight") ) ; 
        Double newHeight = Double.parseDouble(newStudent.get("height") ) ; 
        String newHairColor = newStudent.get("hairColor") ;
        Double newGpa = Double.parseDouble(newStudent.get("gpa") ) ;
        String newOS = newStudent.get("favouriteOS");
        studentRepo.save(new Student(newName, newWeight, newHeight, newHairColor, newGpa, newOS));
        response.setStatus(201) ; 
        return "student/addedUser";

        
    }

}
