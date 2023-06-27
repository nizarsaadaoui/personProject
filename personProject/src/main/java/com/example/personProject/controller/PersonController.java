package com.example.personProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personProject.dtos.PersonDto;
import com.example.personProject.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

  private final PersonService personService;

  @PostMapping("/create")
  public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {

    return personService.create(personDto);

  }

  @GetMapping
  public ResponseEntity<List<PersonDto>> getAll() {

    return personService.getAll();

  }

}
