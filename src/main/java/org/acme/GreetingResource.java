package org.acme;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@BeanParam Data data) {
        return "Hello from RESTEasy Reactive " + data.foo + " " + data.bar;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String helloBug(Data data) {
        return "Hello from RESTEasy Reactive " + data.foo + " " + data.bar;
    }

    @POST
    @Path("/raw")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRaw(DataRaw data) {
        return "Hello from RESTEasy Reactive " + data.foo + " " + data.bar;
    }
}