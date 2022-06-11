package com.jadc1.ProyectoUTP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buscador")
public class BuscadorController {
	
	@GetMapping()
	public String muestraPagina() {
		return "Buscador/buscador";
	}
}