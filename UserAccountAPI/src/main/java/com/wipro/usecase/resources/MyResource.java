package com.wipro.usecase.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.wipro.usecase.models.AccountDetails;
import com.wipro.usecase.models.PersonalDetails;
import com.wipro.usecase.services.UserAccountServices;
import com.wipro.usecase.util.Utility;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {

	UserAccountServices service = new UserAccountServices();

	/**
	 * Method handling HTTP GET requests.
	 * 
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path(value = "/{userName}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetailsIfUserExists(@PathParam(value = "userName") String userName,
			@PathParam(value = "password") String password, @Context UriInfo uriInfo) {
		PersonalDetails details = service.getDetailsIfUserExists(userName, password);
		String accountUri = Utility.getUriForAccount(uriInfo, details);
		details.addLink(accountUri, "accountDetailsUri");

		return Response.status(Status.ACCEPTED).entity(details).header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * Method handling HTTP GET requests.
	 * 
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path(value = "/{userName}/accounts/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountDetails(@PathParam(value = "userName") String userName,
			@PathParam(value = "accountId") int accountId, @Context UriInfo uriInfo) {
		AccountDetails details = service.getAccountDetails(userName, accountId);
		// String uri = Utility.getUriForSelf(uriInfo, details);
		// details.addLink(uri, "self");
		return Response.status(Status.ACCEPTED).entity(details).header("Access-Control-Allow-Origin", "*").build();
	}

	// Add Test Data in table

	@POST
	@Path(value = "addtestdata")
	public void addTestData() {
		service.addTestData();
	}
}
