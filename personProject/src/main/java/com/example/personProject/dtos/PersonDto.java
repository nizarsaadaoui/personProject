package com.example.personProject.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonDto {

  private String lastName;
  private String firstName;
  private LocalDate birthDate;

}
