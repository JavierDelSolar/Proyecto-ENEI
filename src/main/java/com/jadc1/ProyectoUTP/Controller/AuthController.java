package com.jadc1.ProyectoUTP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping("/login")
	public String Login() {
		return "Auth/login";
	}
	
	@GetMapping("/logup")
	public String Logup() {
		return "Auth/logup";
	}
}
