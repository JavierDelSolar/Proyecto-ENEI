package com.jadc1.ProyectoUTP.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jadc1.ProyectoUTP.Model.LibroModel;
import com.jadc1.ProyectoUTP.ModelDAO.LibroDAO;

@Controller
@RequestMapping("/buscador")
public class BuscadorController {
	
	@GetMapping()
	public String muestraPagina() {
		return "Buscador/buscador";
	}
	
	@GetMapping("/libro")
	public String verLibro(HttpServletRequest request, Model modelo, @RequestParam(name = "id") String id){
		LibroDAO libroDAO = new LibroDAO();
		LibroModel libroModel = libroDAO.getLibro(id);
		modelo.addAttribute("libro", libroModel);
		
		return "Buscador/verLibro";
	}
}