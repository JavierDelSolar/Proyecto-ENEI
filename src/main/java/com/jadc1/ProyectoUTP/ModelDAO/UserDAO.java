package com.jadc1.ProyectoUTP.ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jadc1.ProyectoUTP.Config.Conexion;
import com.jadc1.ProyectoUTP.Interface.UserInterface;
import com.jadc1.ProyectoUTP.Model.UserModel;

public class UserDAO implements UserInterface{
	
	Conexion conexion = new Conexion();
	Connection cn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	@Override
	public List<UserModel> listar(UserModel user) {
		List<UserModel> lista = new ArrayList<UserModel>();
		String query = "SELECT * FROM usuarios";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				String config = "<button class='btn btn-success btn-sm' value='"+ rs.getString("usuario") +"'>Editar</button>";
				lista.add(new UserModel(rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("tipo"),
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getString("correo"),
						config
						));
			}
			return lista;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<UserModel> ListarClientes() {
		List<UserModel> lista = new ArrayList<UserModel>();
		String query = "SELECT * FROM usuarios WHERE tipo = 'USER'";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				String config = "<button class='btn btn-success btn-sm button-edit' usuario='"+ rs.getString("usuario") +"'>Editar</button>";
				lista.add(new UserModel(rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("tipo"),
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getString("correo"),
						config
						));
			}
			return lista;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public UserModel getCliente(String usuario){
		UserModel userModel = new UserModel();
		userModel.setUsuario(usuario);
		String query = "SELECT * FROM usuarios WHERE tipo = 'USER' AND usuario = '"+usuario+"'";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				userModel.setUsuario(rs.getString("usuario"));
				userModel.setPassword(rs.getString("password"));
				userModel.setTipo(rs.getString("tipo"));
				userModel.setNombres(rs.getString("nombres"));
				userModel.setApellidos(rs.getString("apellidos"));
				userModel.setCorreo(rs.getString("correo"));				
			}
			return userModel;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public void crearCliente(UserModel userModel) {
		String query = "INSERT INTO usuarios(usuario, password, tipo, nombres, apellidos, correo) VALUES (?,?,'USER',?,?,?)";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, userModel.getUsuario());
			ps.setString(2, userModel.getPassword());
			ps.setString(3, userModel.getNombres());
			ps.setString(4, userModel.getApellidos());
			ps.setString(5, userModel.getCorreo());
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void deleteCliente(String usuario){
		String query = "DELETE FROM usuarios WHERE tipo = 'USER' AND usuario = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, usuario);
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void updateCliente(UserModel userModel) {
		String query = "UPDATE usuarios SET password = ?, nombres = ?, apellidos = ?, correo = ? WHERE tipo = 'USER' AND usuario = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, userModel.getPassword());
			ps.setString(2, userModel.getNombres());
			ps.setString(3, userModel.getApellidos());
			ps.setString(4, userModel.getCorreo());
			ps.setString(5, userModel.getUsuario());
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<UserModel> ListarEmpleados() {
		List<UserModel> lista = new ArrayList<UserModel>();
		String query = "SELECT * FROM usuarios WHERE tipo = 'TRABAJADOR'";
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				String config = "<button class='btn btn-success btn-sm button-edit' usuario='"+ rs.getString("usuario") +"'>Editar</button>";
				lista.add(new UserModel(rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("tipo"),
						rs.getString("nombres"),
						rs.getString("apellidos"),
						rs.getString("correo"),
						config
						));
			}
			return lista;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public UserModel getEmpleado(String usuario){
		UserModel userModel = new UserModel();
		userModel.setUsuario(usuario);
		String query = "SELECT * FROM usuarios WHERE tipo = 'TRABAJADOR' AND usuario = '"+usuario+"'";
		System.out.println(query);
		try {
			cn = conexion.getConnection();
			st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(query);
			while(rs.next()){
				userModel.setUsuario(rs.getString("usuario"));
				userModel.setPassword(rs.getString("password"));
				userModel.setTipo(rs.getString("tipo"));
				userModel.setNombres(rs.getString("nombres"));
				userModel.setApellidos(rs.getString("apellidos"));
				userModel.setCorreo(rs.getString("correo"));				
			}
			return userModel;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public void crearEmpleado(UserModel userModel) {
		String query = "INSERT INTO usuarios(usuario, password, tipo, nombres, apellidos, correo) VALUES (?,?,'TRABAJADOR',?,?,?)";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, userModel.getUsuario());
			ps.setString(2, userModel.getPassword());
			ps.setString(3, userModel.getNombres());
			ps.setString(4, userModel.getApellidos());
			ps.setString(5, userModel.getCorreo());
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void deleteEmpleado(String usuario){
		String query = "DELETE FROM usuarios WHERE tipo = 'TRABAJADOR' AND usuario = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, usuario);
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void updateEmpleado(UserModel userModel) {
		String query = "UPDATE usuarios SET password = ?, nombres = ?, apellidos = ?, correo = ? WHERE tipo = 'TRABAJADOR' AND usuario = ?";
		try {
			cn = conexion.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, userModel.getPassword());
			ps.setString(2, userModel.getNombres());
			ps.setString(3, userModel.getApellidos());
			ps.setString(4, userModel.getCorreo());
			ps.setString(5, userModel.getUsuario());
			ps.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
