package org.cardapio.virtual.controller;

import java.util.Date;

import org.cardapio.virtual.model.beans.Suggestion;
import org.cardapio.virtual.model.db.dao.SuggestionDao;
import org.cardapio.virtual.model.db.dao.SuggestionDaoJPA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuggestionController{	
	@RequestMapping(value = "/addSuggestion", method=RequestMethod.POST)
	public ModelAndView addNewSuggestion(@ModelAttribute("addSug") Suggestion sug, Model model){ 
		
		SuggestionDao dao = new SuggestionDaoJPA();
		
		Suggestion s = new Suggestion();
		s.setTitle(sug.getTitle());
		s.setDescription(sug.getDescription());
		s.setSugDate(new Date());
		s.setEmail(sug.getEmail());
		
		dao.add(s);

		ModelAndView mv = new ModelAndView("addNewSuggestion");
		mv.addObject("msg", "Cadastado com sucesso!");
		return mv; 
	}
	
	@RequestMapping(value = "/suggestion")
	public ModelAndView addNewSuggestion(Model model){
		model.addAttribute("addSug", new Suggestion());
		return  new ModelAndView("addNewSuggestion"); 
	}
}
