package com.game.fizzbuzz.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at application root path)
 */
@Path("/game")
public interface IFizzBuzzEndpoint {

	@GET
    @Path("/{given}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response doFizzBuzz(@PathParam("given")Long given);
}
