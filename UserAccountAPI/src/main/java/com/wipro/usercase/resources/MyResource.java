package com.wipro.usercase.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wipro.usercase.models.PersonalDetails;
import com.wipro.usercase.services.UserAccountServices;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	UserAccountServices service = new UserAccountServices();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path(value = "/{userName}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDetailsIfUserExists(@PathParam(value = "userName") String userName, @PathParam(value = "password") String password) {
    	 PersonalDetails details = service.getDetailsIfUserExists(userName,password);
    	 return Response.status(Status.ACCEPTED).entity(details).header("Access-Control-Allow-Origin", "*").build();
    }
}
