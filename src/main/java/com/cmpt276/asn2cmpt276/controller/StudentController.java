package com.cmpt276.asn2cmpt276.controller;



import java.util.Map;

import java.util.* ; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.cmpt276.asn2cmpt276.model.Student;
import com.cmpt276.asn2cmpt276.model.StudentRepo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;







@Controller 
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;





//     // @PostMapping ("/student/add")  // adding student to db
//     // public String  addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response){ 

//     //     String newName  = newStudent.get("name") ; 
//     //     Double newWeight = Double.parseDouble(newStudent.get("weight") ) ; 
//     //     Double newHeight = Double.parseDouble(newStudent.get("height") ) ; 
//     //     String newHairColor = newStudent.get("hairColor") ;
//     //     Double newGpa = Double.parseDouble(newStudent.get("gpa") ) ;
//     //     String newOS = newStudent.get("favouriteOS");
//     //     Student savedStudent = studentRepo.save(new Student(newName, newWeight, newHeight, newHairColor, newGpa, newOS));
//     //     response.setStatus(201) ; 
        
//     //     return "student/add";
        
        
//     // }

    @GetMapping("/student/visualization")
    public String showDataVisualization(Model model) {
        // Add any necessary logic to retrieve student data or perform other operations
        return "student/visualization"; // Thymeleaf template name without the extension
    }

    @GetMapping("/student/database")
    public String showStudentDatabase(Model model) {

        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "student/database"; // Thymeleaf template name without the extension
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {

        studentRepo.deleteById(id);
        return "redirect:/student/database";
    }

}

