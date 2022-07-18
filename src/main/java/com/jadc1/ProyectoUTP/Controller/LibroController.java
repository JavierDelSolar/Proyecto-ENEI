package com.jadc1.ProyectoUTP.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jadc1.ProyectoUTP.Model.LibroModel;
import com.jadc1.ProyectoUTP.ModelDAO.LibroDAO;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@PostMapping(value="/ListarLibros" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> ListarLibros(@RequestParam(name = "nombre") String nombre,
												@RequestParam(name = "descripcion") String descripcion,
												@RequestParam(name = "autor") String autor,
												@RequestParam(name = "anio") String anio){
		LibroDAO libroDAO = new LibroDAO();
		LibroModel libroM = new LibroModel();
		libroM.setFecha(anio);
		libroM.setNombre(nombre);
		libroM.setDescripcion(descripcion);
		libroM.setAutor(autor);
		List<LibroModel> libroModel = libroDAO.listar(libroM);
		Map<String, List<LibroModel>> aMap = new HashMap<String, List<LibroModel>>();
		aMap.put("data", libroModel);
		
		JSONObject json = new JSONObject(aMap);
		return new ResponseEntity<>(json.toMap(), HttpStatus.OK);
	}
	
	@PostMapping("/ListarLibrosAdmin")
	@ResponseBody
	public ResponseEntity<Object> ListarLibrosAdmin() {
		LibroDAO libroDAO = new LibroDAO();
		List<LibroModel> libroModel = libroDAO.listarLibroAdmin();
		Map<String, List<LibroModel>> aMap = new HashMap<String, List<LibroModel>>();
		aMap.put("data", libroModel);
		
		JSONObject json = new JSONObject(aMap);
		return new ResponseEntity<>(json.toMap(), HttpStatus.OK);
	}
	
	@PostMapping(value="/getLibro", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibroModel getLibro(@RequestBody Map<String, String> libro){
		LibroDAO libroDAO = new LibroDAO();
		LibroModel libroModel = libroDAO.getLibro(libro.get("id"));
		return libroModel;
	}
	
	@PostMapping("/crearLibro")
	@ResponseBody
	public String crearLibro(@RequestParam("pdf") MultipartFile pdf,
							@RequestParam("portada") MultipartFile portada,
							@RequestParam("nombre") String nombre,
							RedirectAttributes redirectAttributes){
		LibroDAO libroDAO = new LibroDAO();
		LibroModel libroModel = new LibroModel();
		return "";
	}
}
