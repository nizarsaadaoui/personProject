package com.example.personProject.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Personne")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long   id;
  @Getter
  @Setter
  @Column(name = "last_name")
  private String lastName;
  @Getter
  @Setter
  @Column(name = "first_name")
  private String firstName;
  @Getter
  @Setter
  @Column(name = "birth_date")
  private LocalDate birthDate;

}
