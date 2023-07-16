package com.example.demo.service;

import com.example.demo.model.Contact;
import com.example.demo.model.Person;


public interface PersonService {
    Person createPerson();
    Person savePerson(Person person);
    void addContact(Person person);
    void removeContact(Person person, Integer contactIndex);
}
