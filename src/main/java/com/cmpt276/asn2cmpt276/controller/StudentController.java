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
        
        return "redirect:/student/database";
    }
        
        
//     // }

    @GetMapping("/student/visualization")
    public String showDataVisualization(Model model) {
        // Add any necessary logic to retrieve student data or perform other operations
        List<Student> students = studentRepo.findAll();
        Collections.sort(students, Comparator.comparing(Student::getName));

        model.addAttribute("students", students);
        return "student/visualization"; // Thymeleaf template name without the extension
    }

    @GetMapping("/student/database")
    public String showStudentDatabase(Model model) {

        List<Student> students = studentRepo.findAll();
        Collections.sort(students, Comparator.comparing(Student::getName));

        model.addAttribute("students", students);
        return "student/database"; // Thymeleaf template name without the extension
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {

        studentRepo.deleteById(id);
        return "redirect:/student/database";
    }

    @GetMapping("/navigate")
    public String navigateToStaticPage() {
        return "redirect:/add.html";
    }

    @GetMapping("/student/edit/{id}")
    public String showEditPage(@PathVariable("id") Integer id, Model model) {
        // Retrieve the student from the database using the provided ID
        Optional<Student> optionalStudent = studentRepo.findById(id);
    
        // Check if the student exists
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
    
            // Add the student object to the model
            model.addAttribute("student", student);
    
            // Return the edit page template name
            return "student/edit";
        } else {
            // Handle the case when the student is not found
            return "error"; // You can create an error.html template to display an error message
        }
    }

    @PostMapping("/student/update/{id}")
public String updateStudent(@PathVariable("id") int id, @RequestParam Map<String, String> updatedStudent, HttpServletResponse response) {
    Optional<Student> optionalStudent = studentRepo.findById(id);

    if (optionalStudent.isPresent()) {
        Student student = optionalStudent.get();

        // Update the student's data using the updatedStudent map
        String newName = updatedStudent.get("name");
        if (newName != null) {
            student.setName(newName);
        }

        Double newWeight = Double.parseDouble(updatedStudent.get("weight"));
        if (newWeight != null) {
            student.setWeight(newWeight);
        }

        Double newHeight = Double.parseDouble(updatedStudent.get("height"));
        if (newHeight != null) {
            student.setHeight(newHeight);
        }

        String newHairColor = updatedStudent.get("hairColor");
        if (newHairColor != null) {
            student.setHairColor(newHairColor);
        }

        Double newGpa = Double.parseDouble(updatedStudent.get("gpa"));
        if (newGpa != null) {
            student.setGpa(newGpa);
        }

        String newOS = updatedStudent.get("favouriteOS");
        if (newOS != null) {
            student.setFavOS(newOS);
        }

        
        // Save the updated student object
        studentRepo.save(student);

        // Redirect to the student database page after updating
        return "redirect:/student/database";
    } else {
        // Handle the case when the student is not found
        return "error";
    }
}
    

    


    

}

