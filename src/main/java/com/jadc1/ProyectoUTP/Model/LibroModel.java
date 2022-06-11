package com.jadc1.ProyectoUTP.Model;

public class LibroModel {
	private int id;
	private String nombre;
	private String descripcion;
	private String autor;
	private String fecha;
	private String ruta_pdf;
	private String ruta_imagen;
	private int id_categoria;
	private int tipo_documento;
	
	public LibroModel() {
		super();
	}
	
	public LibroModel(int id, String nombre, String descripcion, String autor, String fecha, String ruta_pdf,
			String ruta_imagen, int id_categoria, int tipo_documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha = fecha;
		this.ruta_pdf = ruta_pdf;
		this.ruta_imagen = ruta_imagen;
		this.id_categoria = id_categoria;
		this.tipo_documento = tipo_documento;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getRuta_pdf() {
		return ruta_pdf;
	}
	public void setRuta_pdf(String ruta_pdf) {
		this.ruta_pdf = ruta_pdf;
	}
	public String getRuta_imagen() {
		return ruta_imagen;
	}
	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
}
