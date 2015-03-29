package org.cardapio.virtual.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.Product;

public class MenuDaoJPA implements MenuDao{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	@Transactional
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
	
	@Transactional
	public boolean remove(Long id){
		EntityManager em = factory.createEntityManager();
		Menu menu = em.find(Menu.class, id);
		menu.getProduct().clear();
		em.persist(menu);
		if (menu != null) {
			em.getTransaction().begin();
			try{
				 em.remove(menu);
			} catch (Exception e) {
				return false;
			}
			em.getTransaction().commit();
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
	
	public Menu listbyId(Long id){
		if (id != null) {
			EntityManager em = factory.createEntityManager();
			String q = "SELECT m FROM Menu m WHERE m.id =:id";
			Menu m = (Menu) em.createQuery(q).setParameter("id", id).getSingleResult();
			em.close();
			return m;
		}
		return null;
	}
	
	public List<Menu> listbyFranchise(Franchise f){
		EntityManager em = factory.createEntityManager();
		List<Menu> lst = new ArrayList<Menu>();
		try{
			String select = String.format("SELECT m FROM Menu m WHERE m.franchise =:franchise");
			Query query = em.createQuery(select)
					.setParameter("franchise", f);
			lst = query.getResultList();
		}catch(Exception e){
	
		}
		em.close();	
		return lst;
	}
	
	public List<Menu> listbyProduct(Product p){
		EntityManager em = factory.createEntityManager();
		List<Menu> lst = new ArrayList<Menu>();
		try{
			String select = String.format("SELECT m FROM Menu m WHERE m.product =:product");
			Query query = em.createQuery(select)
					.setParameter("product", p.getId());
			lst = query.getResultList();
		}catch(Exception e){
	
		}
		em.close();	
		return lst;
	}
}
