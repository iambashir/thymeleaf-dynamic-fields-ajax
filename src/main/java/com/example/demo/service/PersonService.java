package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    PersonDto createPerson();
    Object savePerson(PersonDto personDto);
    void addContact(Person person);
    void removeContact(Person person, Integer contactIndex);
    List<PersonDto> getAllData();
    Optional<Person> editPerson(Long id);
    void deletePerson(Long id);

    /**---- For rest service ----*/
    //Person updatePerson(Person person);
    //List<Person> getAllPersons();
    //Person getPersonById(Long id);
    //void savePersons(Person person);




}
