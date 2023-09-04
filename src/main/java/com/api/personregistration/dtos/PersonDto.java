package com.api.personregistration.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class PersonDto {

  @NotBlank
  @Size(max = 100)
  private String firstName;
  @NotBlank
  @Size(max = 100)
  private String lastName;
  @NotBlank
  @Size(max = 11)
  @CPF
  private String cpf;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  @Size(max = 10)
  private String dateOfBirth;

}
