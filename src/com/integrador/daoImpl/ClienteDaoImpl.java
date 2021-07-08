package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.dao.ClienteDao;
import com.integrador.model.Cliente;
import com.integrador.utilities.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	private static final String postQ1 = 
			"insert into Usuarios(NombreUsuario, Contrasenia, UserEmail,Descripcion,TipoUsuarioID,Activo) " + 
			"select ?, ?,?, 'Usuario Cliente del sistema','Cliente',1; ";
		
	private static final String postQ2 =" insert into Clientes(FechaNacimiento,FechaAlta, Nombre, Apellido, Nacionalidad, Localidad, Provincia, Email, NroDocumento, Telefono1, Telefono2, usuarioId, Activo)" + 
			" select ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, ? ,LAST_INSERT_ID(),1;";
	
	private static final String cambioDeEstadoQ = "update clientes set activo = ? where idcliente = ?";
	private static final String readAllQ = "select * from clientes where activo = 1";
	
	private static final String getQ = "select * from clientes where clienteId = ?";
	private static final String getUsernameQ = "select * from clientes where clienteId = ?";
	private static final String getNroDocumentoQ = "select * from clientes where clienteId = ?";
	@Override
	public boolean post(Cliente cliente) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean result = false;
		try 
		{
			conexion.getSQLConexion().setAutoCommit(false);
			statement = conexion.getSQLConexion().prepareStatement(postQ1);
			// usuario
			statement.setString(1,cliente.getUsuario().getNombreusuario());
			statement.setString(2,cliente.getUsuario().getContrasenia());
			statement.setString(3,cliente.getUsuario().getEmail());
			statement.executeUpdate(); 
			
			// cliente
			statement = conexion.getSQLConexion().prepareStatement(postQ2);
			statement.setDate(1, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			statement.setString(2,cliente.getNombre());
			statement.setString(3,cliente.getApellido());
			statement.setString(4,cliente.getNacionalidad());
			statement.setString(5,cliente.getLocalidad());
			statement.setString(6,cliente.getProvincia());
			statement.setString(7,cliente.getEmail());
			statement.setString(8,cliente.getNroDocumento());
			statement.setString(9,cliente.getTelefono1());
			statement.setString(10,cliente.getTelefono2());
			statement.executeUpdate(); 
			
			conexion.getSQLConexion().commit();
			result = true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return result;
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
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Cliente reg = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return reg;
	}
	
	public Cliente getByNroDocumento(String nroDocumento) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Cliente reg = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setString(1, nroDocumento);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return reg;
	}
	

	
	public Cliente getByUsername(String username) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Cliente reg = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return reg;
	}
	
	@Override
	public List<Cliente> get() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAllQ);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cliente.add(ResultSetMapper.mapResultCliente(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cliente;
	}

}
