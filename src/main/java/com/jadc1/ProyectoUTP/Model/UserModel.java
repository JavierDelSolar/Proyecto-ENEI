package com.jadc1.ProyectoUTP.Model;

enum TIPO{
	USER, ADMIN, TRABAJADOR
}

public class UserModel {
	private String usuario;
	private String password;
	private String tipo;
	private String nombres;
	private String apellidos;
	private String correo;
	private String config;
	
	public UserModel(String usuario, String password, String tipo, String nombres, String apellidos, String correo) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	public UserModel(String usuario, String password, String tipo, String nombres, String apellidos, String correo, String config) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.config = config;
	}
	
	public UserModel() {
		super();
		this.config = "";
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	};
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getConfig() {
		return config;
	}
}
