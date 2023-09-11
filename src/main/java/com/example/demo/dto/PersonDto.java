package com.example.demo.dto;

import com.example.demo.model.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonDto extends BaseDto {

    private String name;
    private String lastName;
    private List<Contact> contactList = new ArrayList<>();
}
