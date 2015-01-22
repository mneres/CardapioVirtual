package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.Company;
import org.cardapio.virtual.model.beans.Franchise;

public interface FranchiseDao {
	boolean addCompany(Company c);
	
	boolean addFranchise(Franchise f);
	
	List<Franchise> listFranchise();
	
	Franchise listById(Long id);
	
	List<Franchise> listFranchiseByTypeOrName(String type, String name);
	
}
