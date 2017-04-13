package com.wipro.usecase.services;

import com.wipro.usecase.models.PersonalDetails;
import com.wipro.usecase.respository.UserAccountDao;

public class UserAccountServices {

	UserAccountDao userAccountDao = new UserAccountDao();
	public PersonalDetails getDetailsIfUserExists(String userName, String password) {
		return userAccountDao.getDetailsIfUserExists(userName, password);
	}
	public void addUserDetails() {
		userAccountDao.addUserDetails();
	}

}
