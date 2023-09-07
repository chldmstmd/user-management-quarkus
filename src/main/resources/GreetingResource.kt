package org.acme.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.acme.rest.Greeting


@Path("/hello")
class GreetingResource {

    @GET
    fun hello() = Greeting("hi")
}