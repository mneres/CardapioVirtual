package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.Company;
import org.cardapio.virtual.model.beans.Product;

public interface RecomendationDao {
	List<Product> recomendation(Long id_user);
	
	Company CompanylistByProduct(Long id_prod);
}
