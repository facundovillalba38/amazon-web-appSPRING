package com.amazon.amazonwebapp.controller;

import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.amazonwebapp.domain.CachePrice;
import com.amazon.amazonwebapp.service.CachePriceService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListadoController {
	private final CachePriceService cpService;
	
	
	
	public ListadoController(CachePriceService cpService) {
		this.cpService = cpService;
	}



	@RequestMapping("/")
	public String showList(Model model) {
		List<CachePrice>destacados = cpService.buscarDestacados();	
		model.addAttribute("cachePrice", destacados);
		return "lista";
	}
        
        @RequestMapping("/buscar")
	public String buscar(@RequestParam("q")String consulta, Model model) {
		List<CachePrice>destacados = cpService.buscarPorNombre(consulta);	
		model.addAttribute("cachePrice", destacados);
		return "lista";
	}
	
	
	
}
