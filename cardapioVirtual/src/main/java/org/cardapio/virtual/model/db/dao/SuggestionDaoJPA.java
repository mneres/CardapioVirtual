package org.cardapio.virtual.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.cardapio.virtual.model.beans.Suggestion;

public class SuggestionDaoJPA implements SuggestionDao{
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean add(Suggestion s){
		EntityManager em = factory.createEntityManager();
		
		try {
			em.getTransaction().begin();
	        em.persist(s);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		
        em.close();
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Suggestion> list(){
		EntityManager em = factory.createEntityManager();
		List<Suggestion> lst = new ArrayList<Suggestion>();
		
		try {
			Query query = em.createQuery("select s from Suggestion s");
			lst = query.getResultList();
		} catch (Exception e) {
			
		}
	
		em.close();	
		
		return lst;
	}
}
