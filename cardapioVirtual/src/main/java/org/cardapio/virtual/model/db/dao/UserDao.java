package org.cardapio.virtual.model.db.dao;

import org.cardapio.virtual.model.beans.User;

public interface UserDao {
	
	boolean add(User u);
	
	boolean edit(User u);
	
	public User findByEmail(String email);
	
	User findById(Long id);

}
