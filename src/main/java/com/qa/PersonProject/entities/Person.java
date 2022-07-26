package com.qa.PersonProject.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size (min = 2, max = 30)
    @NotNull
    private String firstName;

    @Size (min=2, max=30)
    private String lastName;

    @Min(value = 18)
    @Max(value = 75)
    private int age;

    public Person() {
//        this.firstName = "Lynn";

    }

    public Person(String firstName, String lastName, int age, Long id) {
        // this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
