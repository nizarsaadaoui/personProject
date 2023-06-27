package com.example.personProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.personProject.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


}
