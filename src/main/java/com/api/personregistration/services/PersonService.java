package com.api.personregistration.services;

import com.api.personregistration.models.PersonModel;
import com.api.personregistration.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public boolean existsByCpf(String cpf) {
    return  personRepository.existsByCpf(cpf);
  }

  public boolean existsByEmail(String email) {
    return personRepository.existsByEmail(email);
  }

  public List<PersonModel> findAll() {
    return personRepository.findAll();
  }
}


