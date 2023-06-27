package com.example.personProject.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.personProject.dtos.PersonDto;
import com.example.personProject.models.Person;
import com.example.personProject.repository.PersonRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  private final Mapper           mapper;

  public ResponseEntity<PersonDto> create(PersonDto personDto) {
    if (LocalDate.now().minusYears(personDto.getBirthDate().getYear()).getYear() > 150) {

      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    Person entity = mapper.map(personDto, Person.class);
    Person savedEntity = personRepository.save(entity);

    return new ResponseEntity<>(mapper.map(savedEntity, PersonDto.class), HttpStatus.OK);

  }

  public ResponseEntity<List<PersonDto>> getAll() {
    List<Person> allPersons = personRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
    List<PersonDto> allPersonsDtos = new ArrayList<>(allPersons.size());

    allPersons.forEach(p -> allPersonsDtos.add(mapper.map(p, PersonDto.class)));

    return new ResponseEntity<>(allPersonsDtos, HttpStatus.OK);

  }

}
