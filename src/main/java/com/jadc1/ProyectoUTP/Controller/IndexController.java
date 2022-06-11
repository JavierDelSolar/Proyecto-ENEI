package com.jadc1.ProyectoUTP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String muestraPagina() {
		System.out.print("Prueba");
		return "Home/home";
	}
}