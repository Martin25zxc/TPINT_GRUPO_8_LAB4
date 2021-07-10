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

	private static final String[] postQ = {
			"insert into Usuarios(NombreUsuario, Contrasenia, UserEmail,Descripcion,TipoUsuarioID,Activo, FechaAlta) "
					+ "select ?, ?,?, 'Usuario Cliente del sistema','Cliente',1, now(); ",

			" insert into Clientes(FechaNacimiento,FechaAlta, Nombre, Apellido, Nacionalidad, Provincia, Localidad,Direccion, Email, NroDocumento, Telefono1, Telefono2, usuarioId, Activo)"
					+ " select ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,LAST_INSERT_ID(),1;" };

	private static final String cambioDeEstadoQ = "update clientes set activo = ? where clienteid = ?;";

	private static final String getQ = "select * from clientes ";

	private static final String[] updateQ = {
			" update usuarios  inner join clientes c on usuarios.usuarioid = c.usuarioid "
					+ "set UserEmail= ? where clienteId = ?;",

			" update clientes "
					+ " set FechaNacimiento = ?, Nombre = ?, Apellido = ?, Nacionalidad = ?, Provincia =?, Localidad =?, Direccion = ?, Email = ?, NroDocumento =?, Telefono1 =?, Telefono2=?"
					+ " where clienteId = ?; " };

	@Override
	public boolean post(Cliente cliente) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean result = false;
		try {
			conexion.getSQLConexion().setAutoCommit(false);
			statement = conexion.getSQLConexion().prepareStatement(postQ[0]);
			// usuario
			statement.setString(1, cliente.getUsuario().getNombreUsuario());
			statement.setString(2, cliente.getUsuario().getContrasenia());
			statement.setString(3, cliente.getUsuario().getEmail());
			statement.executeUpdate();

			// cliente
			statement = conexion.getSQLConexion().prepareStatement(postQ[1]);
			statement.setDate(1, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellido());
			statement.setString(4, cliente.getNacionalidad());
			statement.setString(5, cliente.getProvincia());
			statement.setString(6, cliente.getLocalidad());
			statement.setString(7, cliente.getDireccion());
			statement.setString(8, cliente.getEmail());
			statement.setString(9, cliente.getNroDocumento());
			statement.setString(10, cliente.getTelefono1());
			statement.setString(11, cliente.getTelefono2());
			statement.executeUpdate();

			conexion.getSQLConexion().commit();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return result;
	}

	@Override
	public boolean update(Cliente cliente) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean result = false;
		try {
			conexion.getSQLConexion().setAutoCommit(false);
			statement = conexion.getSQLConexion().prepareStatement(updateQ[0]);
			// usuario
			statement.setString(1, cliente.getEmail());
			statement.setInt(2, cliente.getClienteId());
			statement.executeUpdate();

			// cliente
			statement = conexion.getSQLConexion().prepareStatement(updateQ[1]);
			statement.setDate(1, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellido());
			statement.setString(4, cliente.getNacionalidad());
			statement.setString(5, cliente.getProvincia());
			statement.setString(6, cliente.getLocalidad());
			statement.setString(7, cliente.getDireccion());
			statement.setString(8, cliente.getEmail());
			statement.setString(9, cliente.getNroDocumento());
			statement.setString(10, cliente.getTelefono1());
			statement.setString(11, cliente.getTelefono2());
			statement.setInt(12, cliente.getClienteId());
			statement.executeUpdate();

			conexion.getSQLConexion().commit();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		boolean isSuccess = false;
		try {
			statement = conexion.getSQLConexion().prepareStatement(cambioDeEstadoQ);
			statement.setBoolean(1, false);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0) {
				conexion.getSQLConexion().commit();
				isSuccess = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return isSuccess;
	}

	@Override
	public boolean activate(int id) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();

		boolean isSuccess = false;
		try {
			statement = conexion.getSQLConexion().prepareStatement(cambioDeEstadoQ);
			statement.setBoolean(1, true);
			statement.setInt(2, id);
			if (statement.executeUpdate() > 0) {
				conexion.getSQLConexion().commit();
				isSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		try {
			String query = getQ + " where clienteId = ?";
			statement = conexion.getSQLConexion().prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return reg;
	}

	public Cliente getByNroDocumento(String nroDocumento) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Cliente reg = null;
		try {
			String query = getQ + "where nrodocumento = ?";
			statement = conexion.getSQLConexion().prepareStatement(query);
			statement.setString(1, nroDocumento);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return reg;
	}

	public Cliente getByUsername(String username) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Cliente reg = null;
		try {
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCliente(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		try {
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cliente.add(ResultSetMapper.mapResultCliente(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

}
