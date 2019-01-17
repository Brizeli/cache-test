package com.example.cachetest;

import com.example.cachetest.model.Person;
import com.example.cachetest.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.stream.IntStream;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CacheTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheTestApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(PersonRepository repository) {
        return args1 -> {
            IntStream.rangeClosed(1, 100)
                    .mapToObj(id -> new Person(id, "Name" + id))
                    .forEach(repository::save);
        };
    }
}

