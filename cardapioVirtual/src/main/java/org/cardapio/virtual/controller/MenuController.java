package org.cardapio.virtual.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.Product;
import org.cardapio.virtual.model.db.dao.FranchiseDao;
import org.cardapio.virtual.model.db.dao.FranchiseDaoJPA;
import org.cardapio.virtual.model.db.dao.MenuDao;
import org.cardapio.virtual.model.db.dao.MenuDaoJPA;
import org.cardapio.virtual.model.db.dao.ProductDao;
import org.cardapio.virtual.model.db.dao.ProductDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@RequestMapping(value ="/removeProd", method=RequestMethod.POST)
	public @ResponseBody List<String> removeProduct(@RequestParam(value="idMenu", required=true) String idMenu, 
			@RequestParam(value="idProd", required=true) String idProd){
		if(idProd!=null){
			MenuDao menuDao = new MenuDaoJPA();
			Menu m = menuDao.listbyId(Long.parseLong(idMenu));
			List<Product> lst = new ArrayList<Product>();
			for(Product i : m.getProduct()){
				if(i.getId()!=Long.parseLong(idProd)){
					lst.add(i);
				}
			}
			m.getProduct().clear();
			m.getProduct().addAll(lst);

			menuDao.add(m);	
			ProductDao prodDao = new ProductDaoJPA();
			prodDao.remove(Long.parseLong(idProd));

		}
		List<String> l = new ArrayList<String>();
		l.add("Removido com sucesso"); 
		return l;
	}

	@RequestMapping(value ="/addProd", method=RequestMethod.POST)
	public @ResponseBody String addProduct(@RequestParam(value="menu", required=true) String idMenu,
    		@RequestParam(value="description", required=true) String description,
    		@RequestParam(value="ingredients", required=true) String ingredients,
    		@RequestParam(value="price", required=true) String price) {
    	
    	Product prod = new Product();
    	prod.setDescription(description);
    	prod.setIngredients(ingredients);
    	prod.setPrice(Long.parseLong(price));
    	
		MenuDao menuDao = new MenuDaoJPA();
		Menu m = menuDao.listbyId(Long.parseLong(idMenu));

		m.getProduct().add(prod);
		
		menuDao.add(m);
		return "ok";
	}
	
	@RequestMapping(value ="/editProd", method=RequestMethod.POST)
	public @ResponseBody String editProduct(@RequestParam(value="id", required=true) String id,
    		@RequestParam(value="description", required=true) String description,
    		@RequestParam(value="ingredients", required=true) String ingredients,
    		@RequestParam(value="price", required=true) String price) {
		
		ProductDao pdao = new ProductDaoJPA();
    	Product prod = pdao.findById(Long.parseLong(id));
    	prod.setDescription(description);
    	prod.setIngredients(ingredients);
    	prod.setPrice(Long.parseLong(price));
    	
    	pdao.edit(prod);
		return "ok";
	}
	
	@RequestMapping(value ="/addMenu", method=RequestMethod.POST)
	public @ResponseBody String addMenu(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="idFranchise", required=true) String idFranchise){
		MenuDao menuDao = new MenuDaoJPA();
		
		FranchiseDao fraDao = new FranchiseDaoJPA();
		Franchise f = fraDao.listById(Long.parseLong(idFranchise));
		
		Menu m = new Menu();
		m.setName(name.toString());
		m.setFranchise(f);
		
		menuDao.add(m);
		return "ok";
	}
	
}
