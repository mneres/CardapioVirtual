package org.cardapio.virtual.model.db.dao;

import org.cardapio.virtual.model.beans.User;

public interface UserDao {
	
	boolean add(User u);
	
	public User findByEmail(String email);

}
