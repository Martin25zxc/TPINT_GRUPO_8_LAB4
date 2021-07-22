package com.integrador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.*;

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
	
	public static Cuenta mapResultCuenta(ResultSet resultSet) throws SQLException {
		Cuenta cuenta = new Cuenta();
		cuenta.setCuentaId(resultSet.getInt("cuentasCuentaId"));
		cuenta.setClienteId(resultSet.getInt("cuentasClienteId"));
		cuenta.setFechaAlta((resultSet.getDate("cuentasFechaAlta")).toLocalDate());
		cuenta.setNumeroDeCuenta(resultSet.getString("cuentasNumeroDeCuenta"));
		cuenta.setCBU(resultSet.getString("cuentasCBU"));
		cuenta.setAlias(resultSet.getString("cuentasAlias"));
		cuenta.setBancoId(resultSet.getInt("cuentasBancoId"));
		cuenta.setTipoCuentaId(resultSet.getInt("cuentasTipoCuentaId"));
		cuenta.setActivo(resultSet.getBoolean("cuentasActivo"));
		
		Integer tipoCuentaId = resultSet.getInt("tiposCuentasTipoCuentaId");
		if (tipoCuentaId != null && !tipoCuentaId.equals(0)) {
			TipoCuenta tipoCuenta = mapResultTipoCuenta(resultSet);
			cuenta.setTipoCuenta(tipoCuenta);
		}
		
		Integer clienteId = resultSet.getInt("clientesClienteId");
		if (clienteId != null && !tipoCuentaId.equals(0)) {
			Cliente cliente = mapResultCliente(resultSet);
			cuenta.setCliente(cliente);
		}
		
		try
		{
			double saldo = resultSet.getDouble("rmSaldo");
			cuenta.setSaldo(saldo);
		}
		catch(SQLException ex)
		{
			
		}
		
		return cuenta;
	}
	
	public static TipoCuenta mapResultTipoCuenta(ResultSet resultSet) throws SQLException
	{
		TipoCuenta tipoCuenta = new TipoCuenta();
		tipoCuenta.setTipoCuentaId(resultSet.getInt("tiposCuentasTipoCuentaId"));
		tipoCuenta.setNombre(resultSet.getString("tiposCuentasNombre"));
		tipoCuenta.setDescripcion(resultSet.getString("tiposCuentasDescripcion"));
		return tipoCuenta;
	}
	
	public static TipoMovimiento mapResultTipoMovimiento(ResultSet resultSet) throws SQLException
	{
		TipoMovimiento tipoMovimiento = new TipoMovimiento();
		tipoMovimiento.setTipoMovimientoId(resultSet.getInt("tiposMovimientosTipoMovimientoId"));
		tipoMovimiento.setNombre(resultSet.getString("tiposMovimientosNombre"));
		tipoMovimiento.setDescripcion(resultSet.getString("tiposMovimientosDescripcion"));
		return tipoMovimiento;
	}
	
	public static Movimiento mapResultMovimiento(ResultSet resultSet) throws SQLException
	{
		Movimiento movimiento = new Movimiento();
		movimiento.setMovimientoId(resultSet.getInt("movimientosMovimientoID"));
		movimiento.setDetalle(resultSet.getString("movimientosDetalle"));
		movimiento.setImporte(resultSet.getDouble("movimientosImporte"));
		movimiento.setFechaAlta((resultSet.getDate("movimientosFechaAlta")).toLocalDate());
		movimiento.setTipoMovimientoId(resultSet.getInt("movimientosTipoMovimientoID"));
		
		TipoMovimiento tipoMovimiento = mapResultTipoMovimiento(resultSet);
		movimiento.setTipoMovimiento(tipoMovimiento);
		
		return movimiento;
	}
	
	public static ResultadoMovimiento mapResultResultadoMovimiento(ResultSet resultSet) throws SQLException
	{
		ResultadoMovimiento resultadoMovimiento = new ResultadoMovimiento();
		resultadoMovimiento.setResultadoMovimientoId(resultSet.getInt("resultadosmovimientosResultadoMovimientoID"));
		resultadoMovimiento.setMovimientoId(resultSet.getInt("resultadosmovimientosMovimientoId"));
		resultadoMovimiento.setDetalle(resultSet.getString("movimientosDetalle"));
		resultadoMovimiento.setImporte(resultSet.getDouble("resultadosmovimientosImporte"));
		
		Movimiento movimiento = mapResultMovimiento(resultSet);
		resultadoMovimiento.setMovimiento(movimiento);
		
		return resultadoMovimiento;
	}
}
