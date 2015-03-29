package org.cardapio.virtual.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.Franchise;
import org.cardapio.virtual.model.beans.Menu;
import org.cardapio.virtual.model.db.dao.FranchiseDao;
import org.cardapio.virtual.model.db.dao.FranchiseDaoJPA;
import org.cardapio.virtual.model.db.dao.MenuDao;
import org.cardapio.virtual.model.db.dao.MenuDaoJPA;
import org.cardapio.virtual.model.manager.FranchiseLoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/franchise")
public class LogonFranchiseController {
	private FranchiseDao dao = new FranchiseDaoJPA();
	private FranchiseLoginManager manager = new FranchiseLoginManager();
	private Franchise f = new Franchise();
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String login(ModelMap model, HttpSession session,
			HttpServletRequest req, @RequestParam String email,
			@RequestParam String password) {
		f = dao.findByEmail(email);
		String error = "";

		if (f == null) {
			error = "Nenhum usuário encontrado com o email: '" + email + "'!";
		} else if (manager.verifyUser(password, f)) {
			manager.login(f, session);
		} else {
			error = "Senha inválida!";
		}

		if (!error.isEmpty()) {
			model.addAttribute("error", error);
		}

		return "redirect:" + (error.isEmpty() ? "homeFranchise" : "loginFranchise");
	}
	
	
	@RequestMapping(value = "logar", method = RequestMethod.GET)
	public ModelAndView logar(Model model){
		return new ModelAndView("restaurant/franchise/loginFranchise");
	}	
	
	@RequestMapping(value = "logoff", method = RequestMethod.GET)
	public ModelAndView logoff(HttpSession session){
		manager.logout(session);
		return new ModelAndView("restaurant/franchise/loginFranchise");
	}	
	
	@RequestMapping(value = "homeFranchise", method = RequestMethod.GET)
	public ModelAndView homeFranchise(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("restaurant/franchise/homeFranchise");
		System.out.println(f.getEmail());
		mv.addObject("franchise", f);
		
		MenuDao daoMenu = new MenuDaoJPA();
		List<Menu> m = daoMenu.listbyFranchise(f);
		
		mv.addObject("franchise", f);
		mv.addObject("menu", m);
		return mv;
	}	
	
	@RequestMapping(value = "menuControl", method = RequestMethod.GET)
	public ModelAndView edit(){
		return new ModelAndView("restaurant/franchise/menuControl");
	}	
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(
			@RequestParam(value="idfranchise", required=true) String idFranchise,
			@RequestParam(value="product", required=true) String idProduct){
		ModelAndView mv = new ModelAndView("restaurant/franchise/editProduct");
		mv.addObject("franchise",idFranchise);
		mv.addObject("product",idProduct);
		return mv;
	}	
	
	
	@RequestMapping(value = "addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct(
			@RequestParam(value="idfranchise", required=true) String idFranchise){
		ModelAndView mv = new ModelAndView("restaurant/franchise/addProduct");
		mv.addObject("franchise",idFranchise);
		return mv;
	}	
	
	@RequestMapping(value = "addMenu", method = RequestMethod.GET)
	public ModelAndView addMenu(
			@RequestParam(value="idfranchise", required=true) String idFranchise){
		ModelAndView mv = new ModelAndView("restaurant/franchise/addMenu");
		mv.addObject("franchise",idFranchise);
		return mv;
	}
}
