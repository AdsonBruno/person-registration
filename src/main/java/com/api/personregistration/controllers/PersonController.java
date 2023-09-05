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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/persons")
public class PersonController {

  final PersonService personService;


  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto) {
    if (personService.existsByCpf(personDto.getCpf())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Person with CPF already exists.");
    }

    if (personService.existsByEmail(personDto.getEmail())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Person with Email already exists.");
    }

    var personModel = new PersonModel();
    BeanUtils.copyProperties(personDto, personModel);
    personModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
  }

  @GetMapping
  public ResponseEntity<List<PersonModel>> getAllPerson() {
    return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
  }


  @GetMapping("/{id}")
  public ResponseEntity<Object> getOnePerson(@PathVariable(value = "id") UUID id) {
    Optional<PersonModel> personModelOptional = personService.findById(id);
    return personModelOptional.<ResponseEntity<Object>>map(personModel -> ResponseEntity.status(HttpStatus.OK).body(personModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found"));
  }
}
