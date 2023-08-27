package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    Person createPerson();
    Person savePerson(Person person);
    void addContact(Person person);
    void removeContact(Person person, Integer contactIndex);
    List<Person> getAllData();

    Optional<Person> editPerson(Long id);
    Person updatePerson(Person person);

}
