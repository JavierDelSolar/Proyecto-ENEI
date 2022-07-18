package com.jadc1.ProyectoUTP.Interface;

import java.util.List;

import com.jadc1.ProyectoUTP.Model.CategoriaModel;
import com.jadc1.ProyectoUTP.Model.LibroModel;
import com.jadc1.ProyectoUTP.Model.TipoDocumentoModel;

public interface LibroInterface {
	public List<TipoDocumentoModel> listarTipoDocumento();
	public List<CategoriaModel> listarCategoria();
	public List<LibroModel> listar(LibroModel libro);
	public List<LibroModel> listarLibroAdmin();
	public LibroModel getLibro(String id);
}
