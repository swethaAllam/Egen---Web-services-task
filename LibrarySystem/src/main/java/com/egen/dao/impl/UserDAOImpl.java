package com.egen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.dao.UserDAO;
import com.egen.entity.UserEntity;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		try{
		Session sc = session.openSession();
		Transaction tx = sc.beginTransaction();
		users = sc.createQuery("FROM USERENTITY").list();
		sc.flush();
		tx.commit();
		}
		catch(Exception e){
			System.out.println(e + "exception thrown");
		}
		finally{
			session.close();
		}
		return users;
	
	}

	public void updateUser(UserEntity user) {
		try{
			Session sc = session.openSession();
			Transaction tx = sc.beginTransaction();
			sc.save(user);
			sc.flush();
			tx.commit();
			}
			catch(Exception e){
				System.out.println(e + "exception thrown");
			}
			finally{
				session.close();
			}
		
	}

	public void addUser(UserEntity user) {
		try{
			Session sc = session.openSession();
			Transaction tx = sc.beginTransaction();
			User userExisting = 
	                    (User)sc.get(User.class, user.getUserId()); 
	        if(userExisting!=null)
	        	sc.update(userExisting); 
			sc.flush();
			tx.commit();
			}
			catch(Exception e){
				System.out.println(e + "exception thrown");
			}
			finally{
				session.close();
			}
		
	}

}
