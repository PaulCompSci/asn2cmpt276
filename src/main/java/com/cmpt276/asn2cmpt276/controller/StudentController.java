package com.cmpt276.asn2cmpt276.controller;



import java.util.Map;

import java.util.* ; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmpt276.asn2cmpt276.model.Student;
import com.cmpt276.asn2cmpt276.model.StudentRepo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;







@Controller 
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;


    //visaulize data
    @GetMapping("/student/visualize") 
    public String  bringAllData (Model model) { 

        System.out.println("getting all users");
        List<Student> student = studentRepo.findAll() ; 

        model.addAttribute("student" , student) ; 

        return "student/visualize";
    }

    //for deleteting student from database
    @GetMapping("/student/delete") 
    public String  fetchAllStudent (Model model) { 

        System.out.println("getting all users");
        List<Student> student = studentRepo.findAll() ; 

        model.addAttribute("student" , student) ; 

        return "student/delete";
    }

    

    //for modifying student from database
    @GetMapping("/student/modify") 
    public String  getAllStudent (Model model) { 

        System.out.println("getting all users");
        List<Student> student = studentRepo.findAll() ; 

        model.addAttribute("student" , student) ; 

        return "student/modify";
    }

    @PostMapping ("/student/add")  // adding student to db
    public String  addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response){ 

        String newName  = newStudent.get("name") ; 
        Double newWeight = Double.parseDouble(newStudent.get("weight") ) ; 
        Double newHeight = Double.parseDouble(newStudent.get("height") ) ; 
        String newHairColor = newStudent.get("hairColor") ;
        Double newGpa = Double.parseDouble(newStudent.get("gpa") ) ;
        String newOS = newStudent.get("favouriteOS");
        Student savedStudent = studentRepo.save(new Student(newName, newWeight, newHeight, newHairColor, newGpa, newOS));
        response.setStatus(201) ; 
        
        return "redirect:/AddStudent.html";
        
        
    }

}
