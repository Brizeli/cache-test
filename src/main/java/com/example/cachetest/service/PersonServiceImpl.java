package com.example.cachetest.service;

import com.example.cachetest.cache.Cached;
import com.example.cachetest.model.Person;
import com.example.cachetest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Cached
    public Person get(Integer id) {
        return personRepository.get(id);
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(personRepository.getAll());
    }
}
