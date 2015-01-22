package org.cardapio.virtual.controller;

import javax.validation.Valid;

import org.cardapio.virtual.model.beans.User;
import org.cardapio.virtual.model.db.dao.UserDao;
import org.cardapio.virtual.model.db.dao.UserDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController{	
	private static final String addNewUser = "user/addUser";
	private static final String returnUser = "user/addUser";
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public ModelAndView addNewSuggestion(@ModelAttribute @Valid User user, 
											@RequestParam(value="RepeatPassword", required=true) String repeatPassword) {

		ModelAndView mv = new ModelAndView(returnUser);
		
		if(!user.getEmail().isEmpty() && !user.getPassword().isEmpty() && !repeatPassword.isEmpty()){
			if(user.getPassword().equals(repeatPassword)){
				UserDao dao = new UserDaoJPA();
				User u = new User();
				
				u.setEmail(user.getEmail());
				u.setPassword(user.getPassword());
				
				dao.add(u);
				
				mv.addObject("msg", "Cadastrado com Sucesso!");
			}else{
				mv.addObject("msg", "Senha Inválida!");
			}
		}else{
			mv.addObject("msg", "Preencher Todos os Campos!");
		}
		
		return mv; 
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	public ModelAndView addNewSuggestion(@ModelAttribute @Valid User user) {
		
		/*UserDao dao = new UserDaoJPA();
		
		User u = new User();
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		u.setPhone(user.getPhone());
		u.setSecondPhone(user.getSecondPhone());
		u.setDateBirth(user.getDateBirth());
		u.setCpf(user.getCpf());

		Address a = new Address();
		a.setStreet(user.getAddress().getStreet());
		a.setAd_number(user.getAddress().getAd_number());
		a.setNeighborhood(user.getAddress().getNeighborhood());
		a.setCode(user.getAddress().getCode());
		a.setCity(user.getAddress().getCity());
		
		u.setAddress(a);
		u.setPassword("123");
		
		dao.add(u);*/
		
		ModelAndView mv = new ModelAndView("helloworld");
		return mv; 
	}
	
	@RequestMapping(value = "/addUser")
	public ModelAndView redirect(Model model){
		return  new ModelAndView(addNewUser); 
	}
}
