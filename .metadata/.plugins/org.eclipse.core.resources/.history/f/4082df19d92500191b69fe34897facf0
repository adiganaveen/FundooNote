package com.bridgelabz.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.spring.model.UserDetails;

@Repository
	public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int register(UserDetails user) {
		int userId = 0;
		Session session = sessionFactory.getCurrentSession();
		userId = (Integer) session.save(user);
		return userId;
	}

	public UserDetails login(UserDetails user) {
		Session session = sessionFactory.getCurrentSession();
		String hqlQuery = "from UserDetails where userName = :userName and password =:password";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("userName", user.getEmailId());
		query.setParameter("password", user.getPassword());
		UserDetails existingUser = (UserDetails) query.uniqueResult();
		return existingUser;
	}

	public boolean updateUser(UserDetails user) {
return false;

}

	
	public List<UserDetails> getUsersList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(String id) {
		// TODO Auto-generated method stub
}
		
	}