package org.cardapio.virtual.controller;

import java.util.Date;

import org.cardapio.virtual.model.beans.EvaluationProduct;
import org.cardapio.virtual.model.beans.Product;
import org.cardapio.virtual.model.beans.User;
import org.cardapio.virtual.model.db.dao.EvaluationProductDao;
import org.cardapio.virtual.model.db.dao.EvaluationProductDaoJPA;
import org.cardapio.virtual.model.db.dao.ProductDao;
import org.cardapio.virtual.model.db.dao.ProductDaoJPA;
import org.cardapio.virtual.model.db.dao.UserDao;
import org.cardapio.virtual.model.db.dao.UserDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	@RequestMapping(value ="/addEvaluation", method=RequestMethod.POST)
	public @ResponseBody String removeProduct(
			@RequestParam(value="idUser", required=true) String idUser,
			@RequestParam(value="idProd", required=true) String idProd,
			@RequestParam(value="evaluation", required=true) String evaluation,
			@RequestParam(value="comment", required=true) String comment){
		
		Product prod = new Product();
		ProductDao prodDao = new ProductDaoJPA();
		prod = prodDao.findById(Long.parseLong(idProd));
		
		User us = new User();
		UserDao usDao = new UserDaoJPA();
		us = usDao.findById(Long.parseLong(idUser));
		
		EvaluationProduct e = new EvaluationProduct();
		e.setProd(prod);
		e.setUser(us);
		e.setEvaluation(Integer.parseInt(evaluation));
		e.setComment(comment);
		e.setData(new Date(System.currentTimeMillis()));
		
		EvaluationProductDao evaDao = new EvaluationProductDaoJPA();
		
		if (evaDao.addEvaluation(e) == false){
			return "";
		}
		
		return "ok";
	}
}
