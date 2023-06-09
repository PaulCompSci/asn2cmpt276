package com.cmpt276.asn2cmpt276.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//act as the facilator between our code and sql so that we don't have to write any sql cod
public interface  StudentRepo extends JpaRepository <Student, Integer>  {
    List<Student>findByFavOS(String OS) ; //must follow this naming convention
    List<Student> findByNameAndGpa(String name, Double gpa) ;

    
    
}
