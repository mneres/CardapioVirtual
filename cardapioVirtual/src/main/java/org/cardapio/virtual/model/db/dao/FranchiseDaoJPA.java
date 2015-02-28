package org.cardapio.virtual.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.cardapio.virtual.model.beans.Company;
import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.User;

import antlr.StringUtils;

public class FranchiseDaoJPA implements FranchiseDao{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean addCompany(Company c){
		EntityManager em = factory.createEntityManager();
		
		try {
			em.getTransaction().begin();
	        em.persist(c);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		
        em.close();
		
		return true;
	}
	
	public boolean addFranchise(Franchise f){
		EntityManager em = factory.createEntityManager();
		
		try {
			em.getTransaction().begin();
	        em.persist(f);
	        em.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		
        em.close();
		
		return true;
	}
	
	public List<Franchise> listFranchise(){
		EntityManager em = factory.createEntityManager();
		String select = String.format("SELECT f FROM Franchise f");
		TypedQuery<Franchise> query = em.createQuery(select,Franchise.class);
		List<Franchise> lst = query.getResultList();
		em.close();
        return lst;
	}
	
	public List<Franchise> listFranchiseByTypeOrName(String type, String name){
		EntityManager em = factory.createEntityManager();
		List<Franchise> lst = new ArrayList<Franchise>();
		String select = new String();
		
		if(type.isEmpty() && name.isEmpty()){
			return lst;
		}else if(type.isEmpty()){
			 select = String.format("SELECT f FROM Franchise f JOIN f.company c "
			 		+ "where c.companyName = :name ");
				Query query = em.createQuery(select)
						.setParameter("name", name);
				lst = query.getResultList();
		}else if (name.isEmpty()){
			select = String.format("SELECT f FROM Franchise f where f.typeFood =:typeFood ");
			Query query = em.createQuery(select)
					.setParameter("typeFood", type);
			lst = query.getResultList();
		}else{
			select = String.format("SELECT f FROM Franchise f JOIN f.company c "
					+ "where c.companyName = :name and  f.typeFood =:typeFood");
			Query query = em.createQuery(select)
					.setParameter("typeFood", type)
					.setParameter("name", name);
			lst = query.getResultList();
		}
		
		em.close();
        return lst;
	}
	
	public Franchise listById(Long id){
		if (id != null) {
			EntityManager em = factory.createEntityManager();
			String q = "SELECT f FROM Franchise f WHERE f.id =:id";
			Franchise f = (Franchise) em.createQuery(q).setParameter("id", id).getSingleResult();
			em.close();
			return f;
		}
		return null;
	}
	
	public Franchise findByEmail(String email) {
			
			EntityManager em = factory.createEntityManager();
			
			if (!email.isEmpty()) {
				Franchise f = new Franchise();
				String q = "SELECT f FROM Franchise f WHERE f.email =:ema";
				f = (Franchise) em.createQuery(q).setParameter("ema", email).getSingleResult();
				return f;
			}
			return null;
	}
	
}
