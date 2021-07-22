package com.integrador.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.dao.MovimientoDao;
import com.integrador.model.ResultadoMovimiento;
import com.integrador.utilities.Conexion;

public class MovimientoDaoImpl extends baseDaoImpl implements MovimientoDao {
	private final String getRMovimientoCuentaQ = "select "+ this.selectResultadosMovimientosQ + " , "+ this.selectMovimientosQ  + " , "+ this.selectTiposMovimientosQ 
												+ " from resultadosMovimientos inner join Movimientos on resultadosMovimientos.movimientoid =  Movimientos.movimientoid"
												+ " inner join TiposMovimientos on movimientos.Tipomovimientoid =  TiposMovimientos.Tipomovimientoid"
												+ " where resultadosMovimientos.cuentaId = ?"
												+ " order by movimientos.fechaAlta desc" ;

	@Override
	public List<ResultadoMovimiento> getResultadosMovimientosCuenta(int cuentaId) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<ResultadoMovimiento> movimientos = new ArrayList<ResultadoMovimiento>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(getRMovimientoCuentaQ);
			statement.setInt(1, cuentaId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				movimientos.add(ResultSetMapper.mapResultResultadoMovimiento(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movimientos;
	}
	@Override
	public Boolean hacerTransferencia(int cuentaIdOrigen, int cuentaIdDestino, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hacerDeposito(int cuentaId, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hacerRetiro(int cuentaId, double monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
