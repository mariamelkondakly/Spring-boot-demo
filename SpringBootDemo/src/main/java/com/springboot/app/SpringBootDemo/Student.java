package com.springboot.app.SpringBootDemo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student {
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
    }




}
