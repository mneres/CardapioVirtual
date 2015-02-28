package org.cardapio.virtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class LinkController {
		@RequestMapping(value = "/homeIndex", method=RequestMethod.GET)
		public ModelAndView home(Model model){
			return new ModelAndView("index.jsp");
		}
}
