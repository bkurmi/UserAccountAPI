package com.wipro.usecase.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.wipro.usecase.models.PersonalDetails;
import com.wipro.usecase.services.UserAccountServices;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	UserAccountServices service = new UserAccountServices();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path(value = "/{userName}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetailsIfUserExists(@PathParam(value = "userName") String userName,
			@PathParam(value = "password") String password, @Context UriInfo uriInfo) {
		PersonalDetails details = service.getDetailsIfUserExists(userName, password);
		String uri = getUrilForSelf(uriInfo, details);
		details.addLink(uri, "self");
		return Response.status(Status.ACCEPTED).entity(details).header("Access-Control-Allow-Origin", "*").build();
	}

	private String getUrilForSelf(UriInfo uriInfo, PersonalDetails details) {
		String uri = uriInfo.getBaseUriBuilder()
			.path(MyResource.class)
			.path(details.getUserName())
			.path(details.getPassword())
			.build()
			.toString();
		return uri;
	}

//	@GET
//	@Path(value = "/{userName}/account/{accountId}")
//	public void getAccountDetails(@PathParam(value = "userName") String userName) {
//		service.getAccountDetails(userName);
//	}
//	
	@POST
	@Path(value = "/addDetails")
	public void addUserDetails() {
		service.addUserDetails();
	}
}
