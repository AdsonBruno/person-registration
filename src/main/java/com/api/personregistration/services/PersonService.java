package com.api.personregistration.services;

import com.api.personregistration.models.PersonModel;
import com.api.personregistration.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Transactional
  public PersonModel save(PersonModel personModel) {
    return personRepository.save(personModel);
  }
}


