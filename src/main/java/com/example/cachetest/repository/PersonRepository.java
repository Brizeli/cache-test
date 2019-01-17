package com.example.cachetest.repository;

import com.example.cachetest.model.Person;

import java.util.Collection;

public interface PersonRepository {
    Person get(Integer id);

    void save(Person person);

    Collection<Person> getAll();
}
