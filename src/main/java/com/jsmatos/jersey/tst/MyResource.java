package com.jsmatos.jersey.tst;

import com.jsmatos.some.api.NeedsValidation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/it/{id}")
    public String getIt(@NeedsValidation @PathParam("id") String id) {
        return "Got " + id;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/no_validation_needed/{id}")
    public String noValidationNeeded(String id) {
        return "Got " + id;
    }
}
