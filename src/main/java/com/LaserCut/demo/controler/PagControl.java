package com.LaserCut.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PagControl {
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		return "inicio";
	}
	@GetMapping("/Contactos")
	public String contactos(Model model) {
		return "Contactos";	
	}
	@GetMapping("/nosotros")
	public String nosotros(Model model) {
		return "nosotros";	
	}
	@GetMapping("/products")
	public String products(Model model) {
		return "products";
	}
	@GetMapping("/store")
	public String store(Model model) {
		return "store";
	}
	@GetMapping("/admin")
	public String Admin(Model model) {
		return "admin";
	}
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}


}
