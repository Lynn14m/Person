package com.qa.PersonProject.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    public PersonDTO(){
        super();
    }

}
