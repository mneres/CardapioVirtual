package org.cardapio.virtual.model.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cardapio.virtual.model.beans.User;

public class UserDaoJPA implements UserDao {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean add(User u){
		EntityManager em = factory.createEntityManager();
		
		try {
			em.getTransaction().begin();
	        em.persist(u);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		
        em.close();
		
		return true;
	}
	
	public User findByEmail(String email) {
		
		EntityManager em = factory.createEntityManager();
		User us = new User();
		
		if (!email.isEmpty()) {
			String q = "SELECT u FROM User u WHERE u.email =:ema";
			us = (User) em.createQuery(q).setParameter("ema", email).getSingleResult();
			return us;
		}
		return null;
	}

}
