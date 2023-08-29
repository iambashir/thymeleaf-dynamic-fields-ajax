package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("person", personService.createPerson());
        return "index";
    }

    @PostMapping("/addContact")
    public String addContact(Person person){
        personService.addContact(person);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/removeContact")
    public String removeContact(Person person, @RequestParam("removeContact") Integer contactIndex){
        personService.removeContact(person, contactIndex);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/")
    public String save(@Valid Person person, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage", "The submitted data has errors.");
        }else {
            model.addAttribute("person", personService.savePerson(person));
            model.addAttribute("successMessage", "Person saved successfully!");
        }

        return "redirect:/get";
    }

    @GetMapping("/get")
    public String allData(Model model){
        model.addAttribute("getAllData", personService.getAllData());
        return "/list";
    }


    /**-------- Edit Person -----------*/
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        try {
            Optional<Person> person = personService.editPerson(id);
            model.addAttribute("person", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "edit";
    }

    /**---- Delete person --------*/

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/get";

    }


}
