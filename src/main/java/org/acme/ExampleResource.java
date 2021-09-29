package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.reactive.panache.Panache;

import org.acme.entity.Person;
import org.acme.repository.PersonRepository;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.Multi;

@Path("/hello")
public class ExampleResource {

    private ReactiveGreetingService service;
    private PersonRepository personRepository;

    public ExampleResource(ReactiveGreetingService service, PersonRepository personRepository) {

        this.service = service;
        this.personRepository = personRepository;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Uni<String> greeting(String name) {

        return service.greeting(name);
    }

    @POST
    @Path("/person")
    public Uni<Void> savePerson(Person person) {
         return Panache.withTransaction(() -> this.personRepository.persistAndFlush(person));
    }

    @GET
    @Path("/persons")
    public Multi<Person> getPersons() {
        return personRepository.streamAll();
    }

    @GET
    @Path("/person/{id}")
    public Uni<Person> getPerson(@PathParam("id") Long id) {
        return personRepository.findById(id);
    }
}