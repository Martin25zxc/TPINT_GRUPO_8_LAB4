package com.integrador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Cliente;
import com.integrador.model.Usuario;

public  class ResultSetMapper {
	public static Usuario mapResultUsuario(ResultSet resultSet) throws SQLException
	{
		int usuarioId = resultSet.getInt("usuariosUsuarioID");
		String nombreUsuario = resultSet.getString("usuariosNombreUsuario");
		String contrasenia = resultSet.getString("usuariosContrasenia");
		String email = resultSet.getString("usuariosUserEmail");
		String descripcion = resultSet.getString("usuariosDescripcion");
		String tipoUsuarioId= resultSet.getString("usuariosTipoUsuarioID");
		boolean activo = resultSet.getBoolean("usuariosActivo");
		
		Usuario usuario = new Usuario(nombreUsuario,contrasenia , email, descripcion, tipoUsuarioId, activo,(resultSet.getDate("usuariosFechaAlta")).toLocalDate());
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
		cliente.setClienteId(resultSet.getInt("clientesClienteId"));
		cliente.setFechaNacimiento((resultSet.getDate("clientesFechaNacimiento")).toLocalDate());
		cliente.setFechaAlta((resultSet.getDate("clientesFechaAlta")).toLocalDate());
		cliente.setNombre(resultSet.getString("clientesNombre"));
		cliente.setApellido(resultSet.getString("clientesApellido"));
		cliente.setNacionalidad(resultSet.getString("clientesNacionalidad"));
		cliente.setDireccion(resultSet.getString("clientesDireccion"));
		cliente.setLocalidad(resultSet.getString("clientesLocalidad"));
		cliente.setProvincia(resultSet.getString("clientesProvincia"));
		cliente.setNroDocumento(resultSet.getString("clientesNroDocumento"));
		cliente.setTelefono1(resultSet.getString("clientesTelefono1"));
		cliente.setTelefono2(resultSet.getString("clientesTelefono2"));
		cliente.setActivo(resultSet.getBoolean("clientesActivo"));
		cliente.setUsuarioID(resultSet.getInt("clientesUsuarioID"));
		cliente.setEmail(resultSet.getString("clientesEmail"));
		return cliente;
	}
}
