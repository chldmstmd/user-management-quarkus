package org.acme.resource

import jakarta.ws.rs.Consumes
import org.acme.model.Person
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
class PersonResource {

    @GET
    fun list() = Person.listAll()

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun add(person: Person): Person {
        person.persist()
        return person
    }
}