package org.cardapio.virtual.model.db.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.cardapio.virtual.model.beans.Product;

public class ProductDaoJPA implements ProductDao{
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cardapioVirtual");
	
	@Transactional
	public void remove(Long id) {
		EntityManager em = factory.createEntityManager();
		Product obj = em.find(Product.class, (long)id);
		if (obj != null) {
			em.getTransaction().begin();
			  em.remove(obj);
			  em.getTransaction().commit();
		}
		em.close();
	}
	
	public Product findById(Long id){
		if (id != null) {
			EntityManager em = factory.createEntityManager();
			String q = "SELECT p FROM Product p WHERE p.id =:id";
			Product p = (Product) em.createQuery(q).setParameter("id", id).getSingleResult();
			em.close();
			return p;
		}
		return null;
	}
}
