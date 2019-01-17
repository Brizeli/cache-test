package com.example.cachetest.service;

import com.example.cachetest.model.Person;

import java.util.List;

public interface PersonService {

    Person get(Integer id);

    List<Person> getAll();
}
