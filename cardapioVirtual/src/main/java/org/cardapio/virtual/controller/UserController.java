package org.cardapio.virtual.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.cardapio.virtual.model.beans.Address;
import org.cardapio.virtual.model.beans.User;
import org.cardapio.virtual.model.db.dao.UserDao;
import org.cardapio.virtual.model.db.dao.UserDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController{	
	private static final String addNewUser = "user/addUser";
	private static final String returnUser = "user/addUser";
	private static final String editUser = "user/editUser";
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public ModelAndView addNewUser(@ModelAttribute @Valid User user, 
											@RequestParam(value="RepeatPassword", required=true) String repeatPassword) {

		ModelAndView mv = new ModelAndView(returnUser);
		
		if(!user.getEmail().isEmpty() && !user.getPassword().isEmpty() && !repeatPassword.isEmpty()){
			if(user.getPassword().equals(repeatPassword)){
				UserDao dao = new UserDaoJPA();
				User u = new User();
				
				u.setEmail(user.getEmail());
				u.setPassword(user.getPassword());
				
				Address a = new Address();
				a.setStreet("-");
				a.setCity("-");
				a.setCode("0");
				a.setNeighborhood("-");
				a.setAd_number(0);
				
				u.setAddress(a);
				
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
	public @ResponseBody String  editUser(
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="name", required=true) String name,
			@RequestParam(value="phone", required=true) String phone,
			@RequestParam(value="secondPhone", required=true) String secondPhone,
			@RequestParam(value="dateBirth", required=true) String dateBirth,
			@RequestParam(value="cpf", required=true) String cpf,
			@RequestParam(value="street", required=true) String street,
			@RequestParam(value="ad_number", required=true) String ad_number,
			@RequestParam(value="neighborhood", required=true) String neighborhood,
			@RequestParam(value="code", required=true) String code,
			@RequestParam(value="city", required=true) String city) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		UserDao dao = new UserDaoJPA();
		
		User u = new User();
		u = dao.findByEmail(email);
		u.setEmail(email);
		u.setName(name);
		u.setPhone(phone);
		u.setSecondPhone(secondPhone);
		try {
			u.setDateBirth((java.util.Date) formatter.parse(dateBirth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		u.setCpf(cpf);

		Address a = new Address();
		a.setStreet(street);
		a.setAd_number(Integer.parseInt(ad_number));
		a.setNeighborhood(neighborhood);
		a.setCode(code);
		a.setCity(city);
		
		u.setAddress(a);
		
		if (dao.edit(u)==false){
			return "";
		}
		
		return "Ok";
	}
	
	@RequestMapping(value = "/addUser")
	public ModelAndView redirect(Model model){
		return  new ModelAndView(addNewUser); 
	}
	
	@RequestMapping(value = "/editUser")
	public ModelAndView edit(Model model){
		return  new ModelAndView(editUser); 
	}
}
