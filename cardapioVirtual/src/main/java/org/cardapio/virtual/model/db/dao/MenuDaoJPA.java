package org.cardapio.virtual.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;

public class MenuDaoJPA implements MenuDao{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean add(Menu m){
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
	        em.merge(m);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
        em.close();
		return true;
	}
	
	public List<Menu> list(){
		EntityManager em = factory.createEntityManager();
		List<Menu> lst = new ArrayList<Menu>();
		try{
			String select = String.format("SELECT m FROM Menu m");
			TypedQuery<Menu> query = em.createQuery(select,Menu.class);
			lst = query.getResultList();
		}catch(Exception e){
				
		}
		em.close();	
		return lst;
	}
}
