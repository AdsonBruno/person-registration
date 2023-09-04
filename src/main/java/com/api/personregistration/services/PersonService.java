package com.api.personregistration.services;

import com.api.personregistration.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }
}
