package com.example.cachetest.cache;

import com.example.cachetest.model.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Aspect
@Component
public class PersonsCache extends LinkedHashMap<Integer, Person> {
    @Value("${persons-cache.size}")
    private int limit;

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Person> eldest) {
        return this.size() > limit;
    }

    @Around("@annotation(Cached) && args(id)")
    public Person cachePerson(ProceedingJoinPoint jp, int id) throws Throwable {
        Person person = remove(id);
        if (person == null)
            person = (Person) jp.proceed(new Object[]{id});
        put(id, person);
        System.out.println("Cache:");
        forEach((i, p) -> System.out.println(p));
        return person;
    }
}
