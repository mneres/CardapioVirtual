package org.cardapio.virtual.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.cardapio.virtual.model.beans.User;
import org.cardapio.virtual.model.db.dao.UserDao;
import org.cardapio.virtual.model.db.dao.UserDaoJPA;
import org.cardapio.virtual.model.manager.LoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LogonUserController {
	private UserDao dao = new UserDaoJPA();
	private LoginManager manager = new LoginManager();

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String login(ModelMap model, HttpSession session,
			HttpServletRequest req, @RequestParam String email,
			@RequestParam String password) {
		User user = dao.findByEmail(email);
		String error = "";

		if (user == null) {
			error = "Nenhum usuário encontrado com o email: '" + email + "'!";
		} else if (manager.verifyUser(password, user)) {
			manager.login(user, session);
		} else {
			error = "Senha inválida!";
		}

		if (!error.isEmpty()) {
			model.addAttribute("error", error);
		}

		return "redirect:" + (error.isEmpty() ? "homeUser" : "error");
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return  new ModelAndView("user/loginUser");
	}
	
	@RequestMapping(value = "/logar")
	public ModelAndView redirectLogon(Model model){
		return  new ModelAndView("user/loginUser"); 
	}
	
	@RequestMapping(value = "/homeUser")
	public ModelAndView redirectHomeUser(Model model){
		return  new ModelAndView("user/homeUser"); 
	}
	@RequestMapping(value = "/menu")
	public ModelAndView redirectMenu(Model model){
		return  new ModelAndView("common/menu"); 
	}
}
