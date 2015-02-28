package org.cardapio.virtual.model.db.dao;

import org.cardapio.virtual.model.beans.Product;

public interface ProductDao {
	void remove(Long id);
	
	Product findById(Long id);
}
