package org.cardapio.virtual.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.beans.service.KeyGoogle;
import org.cardapio.virtual.model.db.dao.FranchiseDao;
import org.cardapio.virtual.model.db.dao.FranchiseDaoJPA;
import org.cardapio.virtual.model.db.dao.MenuDao;
import org.cardapio.virtual.model.db.dao.MenuDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;


@Controller
@RequestMapping("/restaurants")
public class RestaurantsController {
	
	
	private static final String listOfRestaurants = "restaurant/listOfRestaurants";
	private static final String listByAddress = "restaurant/teste";
	private static final String listById = "restaurant/restaurant";
	private static final String AddEvaluation = "restaurant/product/addEvaluation";
	private static final String EditEvaluation = "restaurant/product/listEvaluation";
	private static final String logar = "";
	
	@RequestMapping(value = "/listByJson", method=RequestMethod.GET)
	public @ResponseBody List<Franchise> listByAddressJson() {
		FranchiseDao franDao = new FranchiseDaoJPA();
		List<Franchise> lst = franDao.listFranchise();
		return lst;
	}
	
	
	@RequestMapping(value = "/listByAddress", method=RequestMethod.GET)
	public ModelAndView listByAddress(
			@RequestParam(value="destination", required=true)String destination,
			@RequestParam(value="distance", required=true)Long distance) {
		
		ModelAndView mv = new ModelAndView(listOfRestaurants);
		GeoApiContext context = new KeyGoogle().getContext();
		FranchiseDao franDao = new FranchiseDaoJPA();
		List<Franchise> lst = franDao.listFranchise();
		List<Franchise> franchises = new ArrayList<Franchise>();
		for(Franchise f : lst){
			try {
				DistanceMatrix matrix = DistanceMatrixApi.newRequest(context)
				        .origins(f.getAddress().getCode())
				        .destinations(destination)
				        .mode(TravelMode.DRIVING)
				        .language("pt-BR")
				        .await();
				
			    for (DistanceMatrixRow row : matrix.rows) {
			        for (DistanceMatrixElement cell : row.elements) {	
			        	  System.out.println(cell.duration);
			        	  System.out.println(cell.distance);
			        	  System.out.println(cell.distance.inMeters);
			        	  System.out.println(cell.status);
			        	  if(cell.status.toString() == "OK" && cell.distance.inMeters <= distance*1000){
			        		  franchises.add(f);
			        	  }
			        }
			    }
			} catch (Exception e) {
				
			}
		}
		
		mv.addObject("restaurants", franchises);
		
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
	
	@RequestMapping(value = "/listById", method=RequestMethod.GET)
	public ModelAndView listById(@RequestParam(value="id", required=true) String id) {
		ModelAndView mv = new ModelAndView(listById);
		
		FranchiseDao franDao = new FranchiseDaoJPA();
		Franchise f = franDao.listById(Long.parseLong(id));
		
		MenuDao menuDao = new MenuDaoJPA();
		List<Menu> m = menuDao.listbyFranchise(f);
		
		mv.addObject("restaurant", f);
		mv.addObject("menu", m);
		
		return mv;
	}
	
	@RequestMapping(value = "/addEvaluation", method=RequestMethod.GET)
	public ModelAndView addEvaluation(HttpSession session,
			@RequestParam(value="idProd", required=true) String idProd) {
		
		ModelAndView mv = new ModelAndView(AddEvaluation);
		
		mv.addObject("idProd", idProd);
		
		return mv;
	}
	
	@RequestMapping(value = "/listEvaluation", method=RequestMethod.GET)
	public ModelAndView addEvaluation(@RequestParam(value="idProd", required=true) String idProd) {
		
		ModelAndView mv = new ModelAndView(EditEvaluation);
		
		mv.addObject("idProd", idProd);
		
		return mv;
	}
}
