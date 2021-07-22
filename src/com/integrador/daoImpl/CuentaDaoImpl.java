package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.integrador.dao.CuentaDao;
import com.integrador.model.Cuenta;
import com.integrador.model.TipoCuenta;
import com.integrador.utilities.Conexion;

public class CuentaDaoImpl extends baseDaoImpl  implements CuentaDao {

	private final String getTiposCuentasQ = "select " + this.selectTiposCuentasCardQ + " from TiposCuentas ";
	private final String [] postQ = {
			"insert into Cuentas (FechaAlta, NumeroDeCuenta, CBU, Alias, BancoId, TipoCuentaID, Activo, ClienteId) " + 
			"select now(), ?, ?, ?,(select bancoid from bancos where nombre = 'Integrador'), ?,1, ? " ,
			
			"insert into Movimientos(Importe, Detalle, TipoMovimientoId, FechaAlta) " + 
			"select 10000, 'Alta de cuenta', (SELECT tipomovimientoId from tiposmovimientos where nombre = 'Alta de cuenta'), now();", 
			
			"insert into ResultadosMovimientos(Importe, Detalle, MovimientoId, CuentaId) " + 
			"select 10000, 'Alta de cuenta',  (SELECT LAST_INSERT_ID()) , (SELECT cuentaid from Cuentas where NumeroDeCuenta = ?);"};
	
	private final String getPartialQuery = " select "+ this.selectCuentasCardQ+" , "+this.selectTiposCuentasCardQ +" , "+this.selectClienteCardQ + ", ifnull(ri.saldo, 0) as rmSaldo"
			+ " from Cuentas inner join TiposCuentas on Cuentas.TipoCuentaId = TiposCuentas.TipoCuentaId "
			+ " inner join clientes on Cuentas.clienteId = clientes.clienteId "
			+ " left join (select sum(Importe) saldo, cuentaid from resultadosmovimientos group by cuentaid) ri on cuentas.cuentaid = ri.cuentaid ";

	private final String getUltimaQ = getPartialQuery + " order by Cuentas.cuentaid desc limit 1 ";
	
	private final String getQ = getPartialQuery + " where Cuentas.cuentaId = ? ";
	
	private final String searchQ = getPartialQuery
			+ "where (?  = '' OR Cuentas.activo = (CASE WHEN ?  = 'F'  THEN 0 WHEN ? = 'T'  THEN 1 END)) and (?  =0 OR Cuentas.clienteId = ? ) ;";
	
	private final String cambioDeEstadoQ = "update cuentas set activo = ? where cuentaid = ?;";
	
	private final String getByAliasQ = getPartialQuery + " where cuentas.alias = ?";

	private final String getByCBUQ = getPartialQuery + " where cuentas.cbu = ?";
	
	private final String updateAliasQ =" update cuentas "
									+ " set alias = ? "
									+ " where cuentaId = ?; ";
							
	@Override
	public boolean post(Cuenta cuenta) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean result = false;
		try {
			conexion.getSQLConexion().setAutoCommit(false);
			statement = conexion.getSQLConexion().prepareStatement(postQ[0]);
			// Cuentas
			statement.setString(1, cuenta.getNumeroDeCuenta());
			statement.setString(2, cuenta.getCBU());
			statement.setString(3, cuenta.getAlias());
			statement.setInt(4, cuenta.getTipoCuentaId());
			statement.setInt(5, cuenta.getClienteId());
			statement.executeUpdate();

			// Movimientos
			statement = conexion.getSQLConexion().prepareStatement(postQ[1]);
			statement.executeUpdate();
			
			// ResultadosMovimientos
			statement = conexion.getSQLConexion().prepareStatement(postQ[2]);
			statement.setString(1, cuenta.getNumeroDeCuenta());
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
	public Cuenta get(int id) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Cuenta reg = null;
		try {
			statement = conexion.getSQLConexion().prepareStatement(getQ);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCuenta(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return reg;
	}
	
	@Override
	public Cuenta getByAlias(String alias) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Cuenta reg = null;
		try {
			statement = conexion.getSQLConexion().prepareStatement(getByAliasQ);
			statement.setString(1, alias);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCuenta(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return reg;	

	}

	@Override
	public Cuenta getByCBU(String cbu) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Cuenta reg = null;
		try {
			statement = conexion.getSQLConexion().prepareStatement(getByCBUQ);
			statement.setString(1, cbu);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				reg = ResultSetMapper.mapResultCuenta(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.cerrarConexion();
		}
		return reg;
	}

	public Cuenta getUltima () {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		Cuenta reg = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(this.getUltimaQ);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				reg = ResultSetMapper.mapResultCuenta(resultSet);
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
	
	/**
	 * Metodo que retorna una lista de cuentas segun los parametros que reciba
	 * @param estado si no es "" buscara por T(True) o F (false)
	 * @param clienteId si se pasa un cliente id que no sea 0 se filtrara por el id del cliente.
	 */
	@Override
	public List<Cuenta> get(String estado , int clienteId) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(searchQ);
			statement.setString(1, estado);
			statement.setString(2, estado);
			statement.setString(3, estado);
			
			statement.setInt(4, clienteId);
			statement.setInt(5, clienteId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cuentas.add(ResultSetMapper.mapResultCuenta(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentas;
	}

	@Override
	public List<TipoCuenta> getTiposCuentas() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<TipoCuenta> tiposCuentas = new ArrayList<TipoCuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getTiposCuentasQ);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				tiposCuentas.add(ResultSetMapper.mapResultTipoCuenta(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tiposCuentas;
	}

	@Override
	public boolean updateAlias(int id, String alias) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		boolean result = false;
		try {
			conexion.getSQLConexion().setAutoCommit(false);
			statement = conexion.getSQLConexion().prepareStatement(updateAliasQ);
		
			statement.setString(1, alias);
			statement.setInt(2, id);
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

}
