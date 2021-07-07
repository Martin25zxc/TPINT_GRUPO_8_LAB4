package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.dao.UsuarioDao;
import com.integrador.model.Usuario;
import com.integrador.utilities.Conexion;

public class UsuarioDaoImpl implements UsuarioDao {
	private static final String autenticarQ ="select * from usuarios u left join clientes c on u.usuarioid = c.usuarioid left join tiposusuarios t on u.tipousuarioid = t.tipousuarioid where u.contrasenia = ? COLLATE utf8mb4_0900_as_cs and u.nombreusuario = ? COLLATE utf8mb4_0900_as_cs";
	
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
}
