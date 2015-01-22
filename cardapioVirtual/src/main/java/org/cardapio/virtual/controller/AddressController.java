package org.cardapio.virtual.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.cardapio.virtual.model.beans.service.Cep;
import org.cardapio.virtual.model.manager.AddressManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddressController {
	
	@RequestMapping(value = "/searchAddress", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam(value="cep", required=true) String ParamCep, Model model){
		RestTemplate restTemplate = new RestTemplate();
		Cep cep = new Cep();

		try{
			 cep = restTemplate.getForObject("http://viacep.com.br/ws/" + ParamCep + "/json/", Cep.class);
		}catch(Exception e){
			
		}
       
        ModelAndView mv = new ModelAndView("user/findEndereco");
        if(!(cep == null)){
    		mv.addObject("cep", cep.getCep());
    		mv.addObject("bairro", cep.getBairro());
    		mv.addObject("localidade", cep.getLocalidade());
    		mv.addObject("logradouro", cep.getLogradouro());
        }else{
        	mv.addObject("error", "CEP inválido");
        }
		return mv;
	}
	
	@RequestMapping(value = "/saveAddress", method=RequestMethod.GET)
	public String save(@RequestParam(value="numero", required=true) int ParamNum, 
								@ModelAttribute @Valid Cep cep, Model model, HttpSession session){
		
		
		AddressManager manager = new AddressManager();
		manager.saveAddress(cep, ParamNum, session);
		
		return "redirect:restaurants/list";
	}	

}
