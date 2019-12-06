package com.cadtimes.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadtimes.app.models.Time;
import com.cadtimes.app.repository.TimeRepository;

@Controller
public class IndexController {
	@Autowired
	private TimeRepository timesrp;
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/salvar")
	public String formCadastro(@Valid Time times, BindingResult result,
			RedirectAttributes attributes){
		if(result.hasErrors()) {
			return "redirect:/";
		}
		timesrp.save(times);
		attributes.addFlashAttribute("message", "Time cadastrado com sucesso!");
		return "redirect:/view";
	}
	@GetMapping("/view")
	public ModelAndView view(){
		ModelAndView mv = new ModelAndView("view");
		Iterable<Time> time = timesrp.findAll();
		mv.addObject("times", time);
		return mv;
	}
	@GetMapping("/delete/{codigo}")
	public String delete(@PathVariable("codigo") Long codigo) {
		timesrp.deleteById(codigo);
		return "redirect:/view";
		
	}
	@GetMapping("/editar/{codigo}")
	public String editar(@PathVariable("codigo") Long codigo, Model modal) {
		modal.addAttribute("dados", timesrp.findById(codigo));
		return "editar";
		
	}
}
