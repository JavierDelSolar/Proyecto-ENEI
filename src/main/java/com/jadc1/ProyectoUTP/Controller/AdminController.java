package com.jadc1.ProyectoUTP.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jadc1.ProyectoUTP.Model.CategoriaModel;
import com.jadc1.ProyectoUTP.Model.TipoDocumentoModel;
import com.jadc1.ProyectoUTP.ModelDAO.LibroDAO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("")
	public String Index() {
		return "Admin/clientes";
	}
	
	@GetMapping("/documentos")
	public String Documentos(HttpServletRequest request, Model modelo) {
		LibroDAO libroDAO = new LibroDAO();
		List<TipoDocumentoModel> listTipoDocumento = libroDAO.listarTipoDocumento();
		List<CategoriaModel> listCategoria = libroDAO.listarCategoria();
		
		modelo.addAttribute("TipoDocumento", listTipoDocumento);
		modelo.addAttribute("Categoria", listCategoria);
		return "Admin/documentos";
	}
	
	@GetMapping("/clientes")
	public String Clientes() {
		return "Admin/clientes";
	}
	
	@GetMapping("/empleados")
	public String Empleados() {
		return "Admin/empleados";
	}
	
	@GetMapping("/graficos")
	public String Graficos() {
		return "Admin/graficos";
	}

}