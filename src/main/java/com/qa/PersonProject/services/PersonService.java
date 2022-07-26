package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.entities.PersonRepo;
import com.qa.PersonProject.exceptions.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// CRUD capabilities put here
// Keep incoming https request and outgoing http responses in controller
@Service
public class PersonService {
    private ModelMapper mapper;

    private PersonRepo repo;

    public PersonService(PersonRepo repo, ModelMapper mapper) { // Inject person repo
        super(); // invokes superclass capabilities
        this.repo = repo;
        this.mapper = mapper; // Creating the model mapper
        // Convertor to do the mapping between the DTO and nonDTO Person class
    }

    public PersonDTO mapToDTO(Person person) {
        return this.mapper.map(person, PersonDTO.class); // map person to the personDTO class
        // get value from one and set it to the other, works because the two classes are similar
    }


    public String test() {
        return "Testing 1, 2, 3";
    }

    public PersonDTO addPerson(Person person) {
        /*
        this.people.add(person);
        return this.people.get(this.people.size() - 1); // Database engine would be giving this back
         */
        Person saved =  this.repo.save(person);
        return this.mapToDTO(saved); // still saving the person but as a DTO
    }

    public List<PersonDTO> getAll() {
        /* return this.people;
         return this.repo.findAll();
         turn collection into a stream so that we can do functional method calls
         map method -> process each item and map it to the function
         collect is a terminating function to turn it into a list collection
         */
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) {
        Person person = this.repo.findById(id).orElseThrow(PersonNotFoundException::new); // repo has built in methods for CRUD
        return this.mapToDTO(person);
    }

    public PersonDTO updatePerson(Long id, Person person) {
        /*
        this.people.remove(Math.toIntExact(id));
        this.people.add(person);
        return this.people.get(Math.toIntExact(id));
         */
        Optional<Person> existingOptional = this.repo.findById(id); // optional -> may or may not be a person
        Person existing = existingOptional.get();
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        existing.setAge(person.getAge());
        Person updated = this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean removePerson(Long id){
        // return this.people.remove(id);
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
