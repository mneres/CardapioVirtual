package org.cardapio.virtual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/restaurants")
public class RestaurantsController {
	@RequestMapping(value = "/listByAddress", method=RequestMethod.GET)
	public ModelAndView addNewSuggestion() {
		ModelAndView mv = new ModelAndView("");
		
		return mv;
	}
}
