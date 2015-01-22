package org.cardapio.virtual.model.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cardapio.virtual.model.beans.Product;

public class ProductDaoJPA implements ProductDao{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean add(Product p){
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
	        em.persist(p);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		
        em.close();
		return true;
	}
}
