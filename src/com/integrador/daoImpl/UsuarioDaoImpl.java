package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.dao.UsuarioDao;
import com.integrador.model.Usuario;
import com.integrador.utilities.Conexion;

public class UsuarioDaoImpl extends baseDaoImpl implements UsuarioDao {
	private final String autenticarQ ="select "+ this.selectUsuariosCardQ +" , "+ this.selectClienteCardQ + "from usuarios left join clientes  on usuarios.usuarioid = clientes.usuarioid left join tiposusuarios  on usuarios.tipousuarioid = tiposusuarios.tipousuarioid where usuarios.contrasenia = ? COLLATE utf8mb4_0900_as_cs and usuarios.nombreusuario = ? COLLATE utf8mb4_0900_as_cs";
	private final String getQ = "select "  + this.selectUsuariosCardQ +" , " + this.selectClienteCardQ +" from usuarios left join clientes on usuarios.usuarioid = clientes.usuarioid left join tiposusuarios t on usuarios.tipousuarioid = t.tipousuarioid where usuarios.usuarioId = ?";
	private final String cambioContraseaniaQ = "update usuarios set contrasenia = ? where usuarioId = ?;";
	@Override
	public Usuario autenticar(String userName, String contrasenia) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Usuario usuario = null;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(autenticarQ);
			statement.setString(1, contrasenia);
			statement.setString(2, userName);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				usuario = ResultSetMapper.mapResultUsuario(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally	{
			conexion.cerrarConexion();
		}
		return usuario;
	}
	
	@Override
	public Usuario get(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Usuario reg = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setInt(1, id);
			System.out.println(statement);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				reg = ResultSetMapper.mapResultUsuario(resultSet);
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
	public boolean cambioContrasenia(int usuarioId, String contrasenia) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		boolean isSuccess = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(cambioContraseaniaQ);
			statement.setString(1, contrasenia);
			statement.setInt(2, usuarioId);
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
}
