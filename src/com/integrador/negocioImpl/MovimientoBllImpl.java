package com.integrador.negocioImpl;

import java.util.List;

import com.integrador.dao.MovimientoDao;
import com.integrador.daoImpl.MovimientoDaoImpl;
import com.integrador.model.ResultadoMovimiento;
import com.integrador.negocio.MovimientoBll;

public class MovimientoBllImpl implements MovimientoBll {
private MovimientoDao movimientoDao;
	
	public MovimientoBllImpl() {
		movimientoDao = new MovimientoDaoImpl();
	}

	@Override
	public List<ResultadoMovimiento> getResultadosMovimientosCuenta(int cuentaId) {
		return movimientoDao.getResultadosMovimientosCuenta(cuentaId);
	}
	
}
