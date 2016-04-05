package com.am.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.am.model.UserProfile;

public class UserDAOImpl implements UserDAO{

	static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getClass());
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean addUser(UserProfile user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		LOGGER.info("User saved successfully, User Details="+user);
        return true;
	}

	public void updateUser(UserProfile user) {
		// TODO Auto-generated method stub
		
	}

	public List<UserProfile> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public UserProfile getUserByEmail(String email) {
		UserProfile user = null;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserProfile where email = :email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<UserProfile> list = (List<UserProfile>) query.list();
		if(!list.isEmpty()){
			user = list.get(0);
		}
		return user;
	}

	public void removeUser(int userID) {
		// TODO Auto-generated method stub
		
	}

}
