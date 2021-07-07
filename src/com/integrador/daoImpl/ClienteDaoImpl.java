package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.integrador.dao.ClienteDao;
import com.integrador.model.Cliente;
import com.integrador.model.Usuario;
import com.integrador.utilities.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	private static final String postQ =
			"insert into Usuarios(NombreUsuario, Contrasenia, Email,Descripcion,TipoUsuarioID,Activo) " + 
			"select ?, ?,?, 'Usuario Cliente del sistema','Cliente',1; " + 
			
			" SELECT LAST_INSERT_ID() INTO @userId;" + 
		
			" insert into Clientes(FechaNacimiento,FechaAlta, Nombre, Apellido, Nacionalidad, Localidad, Provincia, Email, NroDocumento, Telefono1, Telefono2, usuarioId, Activo)" + 
			" select ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, ? ,@userId, 1;"
			+ " SELECT LAST_INSERT_ID() as Id;";
	
	private static final String cambioDeEstadoQ = "update clientes set activo = ? where idcliente = ?";
	private static final String readAllQ = "select * from clientes where activo = 1";
	private static final String getQ = "select * from clientes where clienteId = ?";
	@Override
	public int post(Cliente cliente) {
		PreparedStatement statement;
		ResultSet resultSet; 
		int id = -1;
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(postQ);
			// usuario
			statement.setString(1,cliente.getUsuario().getNombreusuario());
			statement.setString(2,cliente.getUsuario().getContrasenia());
			statement.setString(3,cliente.getUsuario().getEmail());
			// cliente
			statement.setDate(4, java.sql.Date.valueOf(cliente.getFechaNacimiento().toString()));
			statement.setString(5,cliente.getNombre());
			statement.setString(6,cliente.getApellido());
			statement.setString(7,cliente.getNacionalidad());
			statement.setString(8,cliente.getLocalidad());
			statement.setString(9,cliente.getProvincia());
			statement.setString(10,cliente.getEmail());
			statement.setString(11,cliente.getNroDocumento());
			statement.setString(12,cliente.getTelefono1());
			statement.setString(13,cliente.getTelefono2());
			
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				id = resultSet.getInt("Id");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return id;
	}
	
	@Override
	public boolean update(Cliente cliente) {
		return true;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		boolean isSuccess = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(cambioDeEstadoQ);
			statement.setBoolean(1, false);
			statement.setInt(2, id);
			if(statement.executeUpdate() > 0)
			{
				conexion.getSQLConexion().commit();
				isSuccess = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return isSuccess;
	}

	@Override
	public Cliente get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
