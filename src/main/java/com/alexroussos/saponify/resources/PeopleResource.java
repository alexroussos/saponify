package com.alexroussos.saponify.resources;

import com.alexroussos.saponify.core.Person;
import com.alexroussos.saponify.db.PersonDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/people")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

    private final PersonDAO peopleDAO;

    public PeopleResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @POST
    @UnitOfWork
    public Person createPerson(Person person) {
        person.setId(UUID.randomUUID().toString());
        return peopleDAO.create(person);
    }

    @GET
    @UnitOfWork
    public List<Person> listPeople() {
        return peopleDAO.findAll();
    }

}
