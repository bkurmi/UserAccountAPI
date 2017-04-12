package com.wipro.usecase.respository;

import java.util.Date;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.wipro.usercase.models.ErrorMessage;
import com.wipro.usercase.models.PersonalDetails;

public class UserAccountDao {

	@SuppressWarnings("unchecked")
	public PersonalDetails getDetailsIfUserExists(String userName, String password) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<PersonalDetails> details = session.createCriteria(PersonalDetails.class)
				.add(Restrictions.eq("userName", userName)).list();
		session.getTransaction().commit();
		session.close();
		if (details.size() > 0 && userName.equals(details.get(0).getUserName())
				&& password.equalsIgnoreCase(details.get(0).getPassword())) {
			return details.get(0);

		} else {
			ErrorMessage errorMessage = new ErrorMessage(404, "You have Entered wrong id and Password");
			Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
			throw new WebApplicationException(response);
		}

	}

	public void addUserDetails() {
		PersonalDetails userDetails = new PersonalDetails("Bhawesh Kurmi", "D-102, montvert Tropez, Kaspatewasti",
				new Date(), "Pune", "Maharashtra", "India", 12356, "bkurmi", "password", "User");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}

}
