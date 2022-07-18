package com.jadc1.ProyectoUTP.ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jadc1.ProyectoUTP.Config.Conexion;
import com.jadc1.ProyectoUTP.Interface.LibroInterface;
import com.jadc1.ProyectoUTP.Model.CategoriaModel;
import com.jadc1.ProyectoUTP.Model.LibroModel;
import com.jadc1.ProyectoUTP.Model.TipoDocumentoModel;
import com.jadc1.ProyectoUTP.Model.UserModel;

public class LibroDAO implements LibroInterface{
	Conexion conexion = new Conexion();
	Connection cn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	@Override
	public List<TipoDocumentoModel> listarTipoDocumento(){
		List<TipoDocumentoModel> list = new ArrayList<TipoDocumentoModel>();
		String query = "SELECT id, descripcion FROM tipo_doc";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				list.add(new TipoDocumentoModel(rs.getInt("id"), rs.getString("descripcion")));
			}
			return list;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<CategoriaModel> listarCategoria(){
		List<CategoriaModel> list = new ArrayList<CategoriaModel>();
		String query = "SELECT id, descripcion FROM categoria";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				list.add(new CategoriaModel(rs.getInt("id"), rs.getString("descripcion")));
			}
			return list;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<LibroModel> listar(LibroModel libro) {
		List<LibroModel> lista = new ArrayList<LibroModel>();
		String nombre = libro.getNombre()==null||libro.getNombre()==""?"":" AND A.nombre LIKE '%"+libro.getNombre()+"%'";
		String descripcion = libro.getDescripcion()==null||libro.getDescripcion()==""?"":" AND A.descripcion LIKE '%"+libro.getDescripcion()+"%'";
		String autor = libro.getAutor()==null||libro.getAutor()==""?"":" AND A.autor LIKE '%"+libro.getAutor()+"%'";
		String anio = libro.getFecha()==null||libro.getFecha()==""?"":" AND YEAR(A.fecha_creacion) = '"+libro.getFecha()+"'";
		String cat = libro.getId_categoria()==0?"":" AND A.id_categoria = " + libro.getId_categoria();
		String tipo = libro.getTipo_documento()==0?"":" AND A.tipo_documento = " + libro.getTipo_documento();
		
		String Where = nombre+descripcion+autor+anio+cat+tipo;
		String query = "SELECT A.*, B.descripcion AS tipo_doc, C.descripcion AS categoria "
				+ "FROM documento A "
				+ "INNER JOIN tipo_doc B "
				+ "ON A.tipo_documento = B.id "
				+ "INNER JOIN categoria C "
				+ "ON A.id_categoria = C.id "
				+ "WHERE 1"+Where;
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				String ruta = "";
				if(rs.getInt("id")<= 30) {
					ruta = "Files/";
				}else {
					ruta = "";
				}
				String nom = "<img src='/ProyectoUTP/Resources/"+ruta+rs.getString("ruta_imagen")+"' width='100px' height='150px'>";
				String config = "<a href='/ProyectoUTP/buscador/libro?id="+rs.getString("id")+"'>"+rs.getString("nombre")+", "+rs.getString("fecha_creacion")+"</a><br>";
				config = config + "<b>Autor:</b> <span class='fst-italic'>"+rs.getString("Autor")+"</span>";
				lista.add(new LibroModel(rs.getInt("id"), 
						nom, 
						rs.getString("descripcion"), 
						rs.getString("autor"), 
						rs.getString("fecha_creacion"), 
						rs.getString("ruta_pdf"), 
						rs.getString("ruta_imagen"), 
						rs.getInt("id_categoria"), 
						rs.getInt("tipo_documento"),
						rs.getString("categoria"),
						rs.getString("tipo_doc"), 
						config));
			}
			
			return lista;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<LibroModel> listarLibroAdmin(){
		List<LibroModel> lista = new ArrayList<LibroModel>();
		String query = "SELECT A.*, B.descripcion AS tipo_doc, C.descripcion AS categoria "
				+ "FROM documento A "
				+ "INNER JOIN tipo_doc B "
				+ "ON A.tipo_documento = B.id "
				+ "INNER JOIN categoria C "
				+ "ON A.id_categoria = C.id ";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				String config = "<button class='btn btn-success btn-sm button-edit' libro='"+ rs.getInt("id") +"'>Editar</button>";
				lista.add(new LibroModel(rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("descripcion"),
						rs.getString("autor"), 
						rs.getString("fecha_creacion"), 
						rs.getString("ruta_pdf"), 
						rs.getString("ruta_imagen"), 
						rs.getInt("id_categoria"), 
						rs.getInt("tipo_documento"),
						rs.getString("categoria"),
						rs.getString("tipo_doc"), 
						config));
			}
			return lista;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public LibroModel getLibro(String id) {
		LibroModel libroModel = new LibroModel();
		String query = "SELECT A.*, B.descripcion AS tipo_doc, C.descripcion AS categoria "
				+ "FROM documento A "
				+ "INNER JOIN tipo_doc B "
				+ "ON A.tipo_documento = B.id "
				+ "INNER JOIN categoria C "
				+ "ON A.id_categoria = C.id "
				+ "WHERE A.id = "+id;
		
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				libroModel.setId(rs.getInt("id"));
				libroModel.setNombre(rs.getString("nombre"));
				libroModel.setDescripcion(rs.getString("descripcion"));
				libroModel.setAutor(rs.getString("autor"));
				libroModel.setFecha(rs.getString("fecha_creacion"));
				libroModel.setRuta_imagen(rs.getString("ruta_imagen"));
				libroModel.setRuta_pdf(rs.getString("ruta_pdf"));
				libroModel.setId_categoria(rs.getInt("id_categoria"));
				libroModel.setTipo_documento(rs.getInt("tipo_documento"));
				libroModel.setCategoria(rs.getString("categoria"));
			}
			return libroModel;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public void deleteLibro(String libro){
		String query = "DELETE FROM documento WHERE id = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, libro);
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void updateLibro(LibroModel libroModel) {
		String query = "UPDATE documento SET nombre = ?, descripcion = ?, autor = ?, fecha_creacion = ?, id_categoria = ?, tipo_documento = ? WHERE id = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, libroModel.getNombre());
			ps.setString(2, libroModel.getDescripcion());
			ps.setString(3, libroModel.getAutor());
			ps.setString(4, libroModel.getFecha());
			ps.setInt(5, libroModel.getId_categoria());
			ps.setInt(6, libroModel.getTipo_documento());
			ps.setInt(7, libroModel.getId());
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
