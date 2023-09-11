package com.example.demo.service.impl;

import com.example.demo.model.Contact;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Person createPerson() {
        return new Person();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void addContact(Person person) {
        person.getContactList().add(new Contact());
    }

    @Override
    public void removeContact(Person person, Integer contactIndex) {
        person.getContactList().remove(contactIndex.intValue());
    }

    @Override
    public List<Person> getAllData() {
       return (List<Person>) personRepository.findAll();

    }

    @Override
    public Optional<Person> editPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

/*    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public void savePersons(Person person) {

    }*/

}
