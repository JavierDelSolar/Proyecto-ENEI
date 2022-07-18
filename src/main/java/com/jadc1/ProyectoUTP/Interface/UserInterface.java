package com.jadc1.ProyectoUTP.Interface;

import java.util.List;

import com.jadc1.ProyectoUTP.Model.UserModel;

public interface UserInterface {
	public List<UserModel> listar(UserModel user);
	public List<UserModel> ListarClientes();
	public UserModel getCliente(String usuario);
	public void crearCliente(UserModel userModel);
	public void deleteCliente(String usuario);
	public void updateCliente(UserModel userModel);
	public List<UserModel> ListarEmpleados();
	public UserModel getEmpleado(String usuario);
	public void crearEmpleado(UserModel userModel);
	public void deleteEmpleado(String usuario);
	public void updateEmpleado(UserModel userModel);
}
