package com.jadc1.ProyectoUTP.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jadc1.ProyectoUTP.Model.LibroModel;
import com.jadc1.ProyectoUTP.ModelDAO.LibroDAO;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping()
	public String home(HttpServletRequest request, Model modelo) {
		
		LibroDAO libroDAO = new LibroDAO();
		LibroModel libro1 = new LibroModel();
		libro1.setId_categoria(1);
		libro1.setTipo_documento(2);
		LibroModel libro2 = new LibroModel();
		libro2.setId_categoria(2);
		libro2.setTipo_documento(2);
		
		List<LibroModel> lista1 = libroDAO.listar(libro1);
		List<LibroModel> lista2 = libroDAO.listar(libro2);
		
		modelo.addAttribute("Lista1", lista1);
		modelo.addAttribute("Lista2", lista2);
		
		return "Home/home";
	}
}