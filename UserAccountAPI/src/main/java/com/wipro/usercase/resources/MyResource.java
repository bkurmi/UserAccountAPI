package com.wipro.usercase.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public PersonalDetails getDetailsIfUserExists(@PathParam(value = "userName") String userName, @PathParam(value = "password") String password) {
    	 return service.getDetailsIfUserExists(userName,password);
    }
}
