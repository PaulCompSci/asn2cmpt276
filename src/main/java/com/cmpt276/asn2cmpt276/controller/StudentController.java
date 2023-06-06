package com.cmpt276.asn2cmpt276.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmpt276.asn2cmpt276.model.Student;

import ch.qos.logback.core.model.Model;

@Controller 
public class StudentController {
    @GetMapping("/student/view") 
    public String  getAllStudent (Model model) { 
        List<Student> student = new ArrayList<>() ; 

        return "student/showAll";
    }

}
