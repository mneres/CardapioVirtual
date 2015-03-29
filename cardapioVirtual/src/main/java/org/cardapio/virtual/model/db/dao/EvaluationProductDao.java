package org.cardapio.virtual.model.db.dao;

import java.util.List;

import org.cardapio.virtual.model.beans.EvaluationProduct;
import org.cardapio.virtual.model.beans.Product;

public interface EvaluationProductDao {
	boolean addEvaluation(EvaluationProduct evaProd);
	
	public List<EvaluationProduct> findByProduct(Product prod);
}
