package com.integrador.utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  Conexion
{
	public static Conexion instancia;
	private Connection connection;
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "BancoIntegrador";
	
	private Conexion()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = host + dbName;
			this.connection = DriverManager.getConnection(url, user, pass);
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	} 

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			instancia.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}