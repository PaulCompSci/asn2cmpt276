package com.cmpt276.asn2cmpt276.model;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid ;
    private String name;  
    private Double weight ;
    private Double height;
    private String hairColor ;
    private Double gpa; 
    private String favOS ;
    
    public Student() { 

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public Double getGpa() {
        return gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public String getFavOS() {
        return favOS;
    }
    public void setFavOS(String favOS) {
        this.favOS = favOS;
    }
    public Student(String name, Double weight, Double height, String hairColor, Double gpa, String favOS) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
        this.favOS = favOS;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    } 

}