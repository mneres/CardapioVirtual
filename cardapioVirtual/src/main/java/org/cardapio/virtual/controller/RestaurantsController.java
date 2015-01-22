package org.cardapio.virtual.controller;

import java.util.ArrayList;
import java.util.List;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.db.dao.FranchiseDao;
import org.cardapio.virtual.model.db.dao.FranchiseDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/restaurants")
public class RestaurantsController {
	
	
	private static final String listOfRestaurants = "restaurant/listOfRestaurants";
	private static final String listByAddress = "restaurant/teste";
	
	@RequestMapping(value = "/listByJson", method=RequestMethod.GET)
	public @ResponseBody List<Franchise> listByAddress() {
		FranchiseDao franDao = new FranchiseDaoJPA();
		List<Franchise> lst = franDao.listFranchise();
		return lst;
	}
	
	
	@RequestMapping(value = "/listByAddress", method=RequestMethod.GET)
	public ModelAndView listbyJson() {
		ModelAndView mv = new ModelAndView(listByAddress);
		
		FranchiseDao franDao = new FranchiseDaoJPA();
		List<Franchise> lst = franDao.listFranchise();
		
		mv.addObject("restaurants", lst);
		
		return mv;
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView(listOfRestaurants);
		
		FranchiseDao franDao = new FranchiseDaoJPA();
		List<Franchise> lst = franDao.listFranchise();
		
		mv.addObject("restaurants", lst);
		
		return mv;
	}
	
	@RequestMapping(value = "/listByTypeOrName", method=RequestMethod.GET)
	public ModelAndView listByTypeOrName(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="type", required=true) String type) {
		
		ModelAndView mv = new ModelAndView(listOfRestaurants);
		List<Franchise> lst = new ArrayList<Franchise>();
		FranchiseDao franDao = new FranchiseDaoJPA();
		
		if(name.isEmpty()&&type.isEmpty()){
			lst = franDao.listFranchise();
		}else{
			lst = franDao.listFranchiseByTypeOrName(type, name);
		}
		
		mv.addObject("restaurants", lst);
		mv.addObject("restaurantName", name);
		mv.addObject("restaurantType", type);
		
		return mv;
	}
}
