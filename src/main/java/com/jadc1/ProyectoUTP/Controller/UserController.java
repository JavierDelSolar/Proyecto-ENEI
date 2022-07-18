package com.jadc1.ProyectoUTP.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jadc1.ProyectoUTP.Model.UserModel;
import com.jadc1.ProyectoUTP.ModelDAO.UserDAO;


@Controller
@RequestMapping("/user")
public class UserController {

	@PostMapping("/ListarClientes")
	@ResponseBody
	public ResponseEntity<Object> ListarClientes() {
		UserDAO userDAO = new UserDAO();
		List<UserModel> userModel = userDAO.ListarClientes();
		Map<String, List<UserModel>> aMap = new HashMap<String, List<UserModel>>();
		aMap.put("data", userModel);
		
		JSONObject json = new JSONObject(aMap);
		return new ResponseEntity<>(json.toMap(), HttpStatus.OK);
	}
	
	@PostMapping(value="/getCliente", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserModel getCliente(@RequestBody Map<String, String> user){
		UserDAO userDAO = new UserDAO();
		UserModel userM = userDAO.getCliente(user.get("usuario"));
		return userM;
	}
	
	@PostMapping(value="/crearCliente")
	@ResponseBody
	public boolean crearCliente(@RequestBody Map<String, String> user){
		UserModel userM = new UserModel();
		userM.setUsuario(user.get("usuario"));
		userM.setPassword(user.get("password"));
		userM.setNombres(user.get("nombres"));
		userM.setApellidos(user.get("apellidos"));
		userM.setCorreo(user.get("correo"));
		
		UserDAO userDAO = new UserDAO();
		userDAO.crearCliente(userM);
		return true;
	}
	
	@PostMapping(value="/updateCliente")
	@ResponseBody
	public boolean updateCliente(@RequestBody Map<String, String> user){
		UserModel userM = new UserModel();
		userM.setUsuario(user.get("usuario"));
		userM.setPassword(user.get("password"));
		userM.setNombres(user.get("nombres"));
		userM.setApellidos(user.get("apellidos"));
		userM.setCorreo(user.get("correo"));
		
		UserDAO userDAO = new UserDAO();
		userDAO.updateCliente(userM);
		return true;
	}
	
	@PostMapping(value="/deleteCliente")
	@ResponseBody
	public boolean deleteCliente(@RequestBody Map<String, String> user){
		UserDAO userDAO = new UserDAO();
		userDAO.deleteCliente(user.get("usuario"));
		return true;
	}
	
	@PostMapping("/ListarEmpleados")
	@ResponseBody
	public ResponseEntity<Object> ListarEmpleados() {
		UserDAO userDAO = new UserDAO();
		List<UserModel> userModel = userDAO.ListarEmpleados();
		Map<String, List<UserModel>> aMap = new HashMap<String, List<UserModel>>();
		aMap.put("data", userModel);
		
		JSONObject json = new JSONObject(aMap);
		return new ResponseEntity<>(json.toMap(), HttpStatus.OK);
	}
	
	@PostMapping(value="/getEmpleado", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserModel getEmpleado(@RequestBody Map<String, String> user){
		UserDAO userDAO = new UserDAO();
		UserModel userM = userDAO.getEmpleado(user.get("usuario"));
		return userM;
	}
	
	@PostMapping(value="/crearEmpleado")
	@ResponseBody
	public boolean crearEmpleado(@RequestBody Map<String, String> user){
		UserModel userM = new UserModel();
		userM.setUsuario(user.get("usuario"));
		userM.setPassword(user.get("password"));
		userM.setNombres(user.get("nombres"));
		userM.setApellidos(user.get("apellidos"));
		userM.setCorreo(user.get("correo"));
		
		UserDAO userDAO = new UserDAO();
		userDAO.crearEmpleado(userM);
		return true;
	}
	
	@PostMapping(value="/updateEmpleado")
	@ResponseBody
	public boolean updateEmpleado(@RequestBody Map<String, String> user){
		UserModel userM = new UserModel();
		userM.setUsuario(user.get("usuario"));
		userM.setPassword(user.get("password"));
		userM.setNombres(user.get("nombres"));
		userM.setApellidos(user.get("apellidos"));
		userM.setCorreo(user.get("correo"));
		
		UserDAO userDAO = new UserDAO();
		userDAO.updateEmpleado(userM);
		return true;
	}
	
	@PostMapping(value="/deleteEmpleado")
	@ResponseBody
	public boolean deleteEmpleado(@RequestBody Map<String, String> user){
		UserDAO userDAO = new UserDAO();
		userDAO.deleteEmpleado(user.get("usuario"));
		return true;
	}
}
