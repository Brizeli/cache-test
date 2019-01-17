package com.example.cachetest.repository;

import com.example.cachetest.model.Person;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private Map<Integer, Person> persons = new HashMap<>();

    @Override
    @SneakyThrows
    public Person get(Integer id) {
        Thread.sleep(2000);
        return persons.get(id);
    }

    @Override
    public void save(Person person) {
        persons.put(person.getId(), person);
    }

    @Override
    public Collection<Person> getAll() {
        return persons.values();
    }
}
