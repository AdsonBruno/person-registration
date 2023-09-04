package com.api.personregistration.controllers;

import com.api.personregistration.dtos.PersonDto;
import com.api.personregistration.models.PersonModel;
import com.api.personregistration.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/person-registration")
public class PersonController {

  final PersonService personService;


  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto) {
    var personModel = new PersonModel();
    BeanUtils.copyProperties(personDto, personModel);
    personModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
  }

}
