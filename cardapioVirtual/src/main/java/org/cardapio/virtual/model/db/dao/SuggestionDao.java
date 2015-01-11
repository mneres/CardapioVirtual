package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.Suggestion;

public interface SuggestionDao{
	
	boolean add(Suggestion s);
	
	List<Suggestion> list();
	
	/*boolean remove(long id);
	
	boolean update(Suggestion s);*/
}
