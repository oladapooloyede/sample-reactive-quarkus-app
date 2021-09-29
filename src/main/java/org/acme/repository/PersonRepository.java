package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.Person;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    
}
