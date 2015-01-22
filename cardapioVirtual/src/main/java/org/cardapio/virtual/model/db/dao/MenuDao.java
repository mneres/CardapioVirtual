package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.Menu;

public interface MenuDao {
	boolean add(Menu m);
	
	List<Menu> list();
}
