package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class HelloResource {
    @GET
    @Path("{name}")
    public String test(@PathParam("name") String name) {
        return "Ciao " + name.toUpperCase();
    }
}
