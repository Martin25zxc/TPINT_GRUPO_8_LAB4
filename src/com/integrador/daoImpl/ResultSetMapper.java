package com.integrador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Cliente;
import com.integrador.model.Usuario;

public  class ResultSetMapper {
	public static Usuario mapResultUsuario(ResultSet resultSet) throws SQLException
	{
		int usuarioId = resultSet.getInt("UsuarioID");
		String nombreUsuario = resultSet.getString("NombreUsuario");
		String contrasenia = resultSet.getString("Contrasenia");
		String email = resultSet.getString("UserEmail");
		String descripcion = resultSet.getString("Descripcion");
		String tipoUsuarioId= resultSet.getString("TipoUsuarioID");
		boolean activo = resultSet.getBoolean("Activo");
		Usuario usuario = new Usuario(nombreUsuario,contrasenia , email, descripcion, tipoUsuarioId, activo);
		usuario.setUsuarioId(usuarioId);
		
		if(tipoUsuarioId.equals("Cliente"))
		{
			Cliente cliente = mapResultCliente(resultSet);
			usuario.setCliente(cliente);
		}
		
		return usuario;
	}
	
	public static Cliente mapResultCliente(ResultSet resultSet) throws SQLException
	{
		Cliente cliente = new Cliente();
		cliente.setClienteId(resultSet.getInt("clienteID"));
		cliente.setFechaNacimiento((resultSet.getDate("FechaNacimiento")).toLocalDate());
		cliente.setFechaAlta((resultSet.getDate("FechaAlta")).toLocalDate());
		cliente.setNombre(resultSet.getString("Nombre"));
		cliente.setApellido(resultSet.getString("Apellido"));
		cliente.setNacionalidad(resultSet.getString("Nacionalidad"));
		cliente.setDireccion(resultSet.getString("Direccion"));
		cliente.setLocalidad(resultSet.getString("Localidad"));
		cliente.setProvincia(resultSet.getString("Provincia"));
		cliente.setNroDocumento(resultSet.getString("NroDocumento"));
		cliente.setTelefono1(resultSet.getString("Telefono1"));
		cliente.setTelefono2(resultSet.getString("Telefono2"));
		cliente.setActivo(resultSet.getBoolean("Activo"));
		cliente.setUsuarioID(resultSet.getInt("UsuarioID"));
		cliente.setEmail(resultSet.getString("Email"));
		return cliente;
	}
}
