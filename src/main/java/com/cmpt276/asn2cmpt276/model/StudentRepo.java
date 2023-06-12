package com.cmpt276.asn2cmpt276.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface  StudentRepo extends JpaRepository <Student, Integer>  {
    List<Student>findByFavOS(String OS) ; //must follow this naming convention
    List<Student> findByNameAndGpa(String name, Double gpa) ;

    //order student alphabatically
    @Query("SELECT s FROM Student s ORDER BY s.name ASC")
    List<Student> findAllOrderedByName();
    
    
}
