package com.jadc1.ProyectoUTP.ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jadc1.ProyectoUTP.Config.Conexion;
import com.jadc1.ProyectoUTP.Interface.LibroInterface;
import com.jadc1.ProyectoUTP.Model.LibroModel;

public class LibroDAO implements LibroInterface{
	Conexion conexion = new Conexion();
	Connection cn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	@Override
	public List<LibroModel> listar(LibroModel libro) {
		List<LibroModel> lista = new ArrayList<LibroModel>();
		String nombre = libro.getNombre()==null||libro.getNombre()==""?"":" AND nombre LIKE '%"+libro.getNombre()+"%'";
		String descripcion = libro.getDescripcion()==null||libro.getDescripcion()==""?"":" AND descripcion LIKE '%"+libro.getDescripcion()+"%'";
		String autor = libro.getAutor()==null||libro.getAutor()==""?"":" AND autor LIKE '%"+libro.getAutor()+"%'";
		String anio = libro.getFecha()==null||libro.getFecha()==""?"":" AND YEAR(fecha_creacion) = '"+libro.getFecha()+"'";
		String categoria = libro.getId_categoria()==0?"":" AND id_categoria = " + libro.getId_categoria();
		String tipo = libro.getTipo_documento()==0?"":" AND tipo_documento = " + libro.getTipo_documento();
		
		String Where = nombre+descripcion+autor+anio+categoria+tipo;
		String query = "SELECT * "
				+ "FROM documento "
				+ "WHERE 1"+Where;
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				lista.add(new LibroModel(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("autor"), rs.getString("fecha_creacion"), rs.getString("ruta_pdf"), rs.getString("ruta_imagen"), rs.getInt("id_categoria"), rs.getInt("tipo_documento")));
			}
			
			return lista;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
