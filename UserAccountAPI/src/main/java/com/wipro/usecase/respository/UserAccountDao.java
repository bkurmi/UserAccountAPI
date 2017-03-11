package com.wipro.usecase.respository;

import java.util.Date;

import com.wipro.usercase.models.PersonalDetails;

public class UserAccountDao {

	public PersonalDetails getDetailsIfUserExists(String userName, String password) {
		
		if("bkurmi".equalsIgnoreCase(userName) && "123456".equalsIgnoreCase(password)){
			return new PersonalDetails("Bhawesh Kurmi", "D-102, montvert Tropez, Kaspatewasti", new Date(), "Pune", "Maharashtra", "India");
		}else{
			return null;
		}
		
	}

}
