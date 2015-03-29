package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.Product;

public interface MenuDao {
	boolean add(Menu m);
	
	boolean remove(Long id);
	
	List<Menu> list();
	
	public Menu listbyId(Long id);

	List<Menu> listbyFranchise(Franchise f);
	
	List<Menu> listbyProduct(Product p);
}
