package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private PersonService service;

    // Constructor dependency injection
    public PersonController(PersonService service) {
        super(); // Calls superclass controller so that it can set itself up
        this.service = service; // go to service and inject
    }

    @GetMapping("/test")
    public String test() {
        return "Testing 1, 2, 3";
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {
        return this.service.getAll();
    }

    // Implement get by id method
    // Add specific person not found exception
    // This is a comment
    @GetMapping("/getPersonById/{id}")
    public PersonDTO getPersonById(@PathVariable("id") Long id){
        return this.service.getPersonById(id);
    }

    @PutMapping("/update")
    public PersonDTO updatePerson(@PathParam("id") Long id, @RequestBody Person person) {
        return this.service.updatePerson(id, person);
//        this.service.remove(Math.toIntExact(id));
//        this.people.add(person);
//        return this.people.get(Math.toIntExact(id));
    }

    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable("id") Long id){
//        return this.people.remove(id);
        return this.service.removePerson(id);
    }
}