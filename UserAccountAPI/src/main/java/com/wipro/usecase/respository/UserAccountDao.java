package com.wipro.usecase.respository;

import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wipro.usercase.models.ErrorMessage;
import com.wipro.usercase.models.PersonalDetails;

public class UserAccountDao {

	public PersonalDetails getDetailsIfUserExists(String userName, String password) {
		if ("bkurmi".equalsIgnoreCase(userName) && "123456".equalsIgnoreCase(password)) {
			return new PersonalDetails("Bhawesh Kurmi", "D-102, montvert Tropez, Kaspatewasti", new Date(), "Pune",
					"Maharashtra", "India");
		} else {
			ErrorMessage errorMessage = new ErrorMessage(404, "You have Entered wrong id and Password");
			Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
			throw new WebApplicationException(response);
		}

	}

}
