package com.api.personregistration.services;

import com.api.personregistration.models.PersonModel;
import com.api.personregistration.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

  public Page<PersonModel> findAll(Pageable pageable) {
    return personRepository.findAll(pageable);
  }

  public Optional<PersonModel> findById(UUID id) {
    return personRepository.findById(id);
  }

  @Transactional
  public void delete(PersonModel personModel) {
    personRepository.delete(personModel);
  }
}


