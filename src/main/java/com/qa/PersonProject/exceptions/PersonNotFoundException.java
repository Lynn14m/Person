package com.qa.PersonProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person with that ID does not exist")

public class PersonNotFoundException extends EntityNotFoundException {

}
