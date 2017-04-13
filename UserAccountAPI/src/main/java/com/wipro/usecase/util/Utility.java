package com.wipro.usecase.util;

import javax.ws.rs.core.UriInfo;

import com.wipro.usecase.models.PersonalDetails;
import com.wipro.usecase.resources.MyResource;

public class Utility {

	public static String getUriForSelf(UriInfo uriInfo, PersonalDetails details) {
		String uri = uriInfo.getBaseUriBuilder().path(MyResource.class).path(details.getUserName())
				.path(details.getPassword()).build().toString();
		return uri;
	}

	public static String getUriForAccount(UriInfo uriInfo, PersonalDetails details) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MyResource.class)
				.path(details.getUserName())
				.path("accounts")
				.path(details.getAccountId()+"").build().toString();
		return uri;
	}

}
