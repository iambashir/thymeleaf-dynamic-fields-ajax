package com.example.demo.service;

import com.example.demo.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    void saveContact(Contact contact);
}
