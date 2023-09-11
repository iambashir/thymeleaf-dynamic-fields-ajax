package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person extends BaseModel{

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Contact> contactList = new ArrayList<>();

    public Optional<Object> stream() {
        return null;
    }
}
