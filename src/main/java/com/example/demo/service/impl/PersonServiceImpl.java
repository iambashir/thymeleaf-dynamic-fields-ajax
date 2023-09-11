package com.example.demo.service.impl;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Contact;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public PersonDto createPerson() {
        Person persons = modelMapper.map(new PersonDto(), Person.class);
        return modelMapper.map(persons, PersonDto.class);
    }

    @Override
    public Object savePerson(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        personRepository.save(person);
        return null;
    }

    @Override
    public void addContact(PersonDto personDto) {
        modelMapper.map(personDto.getContactList().add(new Contact()), Person.class);
    }

    @Override
    public void removeContact(PersonDto personDto, Integer contactIndex) {
        modelMapper.map(personDto.getContactList().remove(contactIndex.intValue()), Person.class);
    }

    @Override
    public List<PersonDto> getAllData() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(person -> modelMapper.map(person, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonDto> editPerson(Long id) {
     Person personEdit = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        return modelMapper.map(personEdit, (Type) PersonDto.class);
       // return Optional.empty();
    }

    @Override
    public void deletePerson(Long id) {
       Person persons = personRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        personRepository.delete(persons);
    }



/*    @Override
    public void addContact(Person person) {
        person.getContactList().add(new Contact());
    }

    @Override
    public void removeContact(Person person, Integer contactIndex) {
        person.getContactList().remove(contactIndex.intValue());
    }

    @Override
    public List<Person> getAllData() {
        return personRepository.findAll();

    }

    @Override
    public Optional<Person> editPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }*/



   /* @Override
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
