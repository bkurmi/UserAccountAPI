package com.wipro.usercase.services;

import com.wipro.usecase.respository.UserAccountDao;
import com.wipro.usercase.models.PersonalDetails;

public class UserAccountServices {

	UserAccountDao userAccountDao = new UserAccountDao();
	public PersonalDetails getDetailsIfUserExists(String userName, String password) {
		return userAccountDao.getDetailsIfUserExists(userName, password);
	}
	public void addUserDetails() {
		userAccountDao.addUserDetails();
	}

}
