package org.cardapio.virtual.model.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.cardapio.virtual.model.beans.EvaluationProduct;
import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.Product;

public class EvaluationProductDaoJPA implements EvaluationProductDao {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	public boolean addEvaluation(EvaluationProduct evaProd){
			EntityManager em = factory.createEntityManager();
			
			try {
				em.getTransaction().begin();
		        em.merge(evaProd);
		        em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
			
	        em.close();
			
			return true;
	}

	public List<EvaluationProduct> findByProduct(Product prod){
		EntityManager em = factory.createEntityManager();
		List<EvaluationProduct> lst = new ArrayList<EvaluationProduct>();
		try{
			String q = "SELECT p FROM EvaluationProduct p WHERE p.prod =:prod order by p.data desc";
			Query query = em.createQuery(q)
					.setParameter("prod", prod);
			lst = query.getResultList();
		}catch(Exception e){
	
		}
		em.close();	
		return lst;
	}
}
