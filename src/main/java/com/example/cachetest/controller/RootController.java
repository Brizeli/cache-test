package com.example.cachetest.controller;

import com.example.cachetest.model.Person;
import com.example.cachetest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class RootController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> people() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return personService.get(id);
    }
}
