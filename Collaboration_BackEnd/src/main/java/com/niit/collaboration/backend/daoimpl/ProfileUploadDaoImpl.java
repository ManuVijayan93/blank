package com.niit.collaboration.backend.daoimpl;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.backend.dao.ProfileUploadDao;
import com.niit.collaboration.backend.model.ProfilePicture;
@Transactional
@Repository
public class ProfileUploadDaoImpl implements ProfileUploadDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(ProfilePicture profilePicture) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(profilePicture);
		tx.commit();
		session.flush();
		session.close();

	}

	public ProfilePicture getProfilePic(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ProfilePicture profilePic = (ProfilePicture) session.get(ProfilePicture.class, username);
		tx.commit();
		session.flush();
		session.close();
		return profilePic;
	}

}