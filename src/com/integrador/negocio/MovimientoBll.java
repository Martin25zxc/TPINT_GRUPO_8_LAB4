package com.integrador.negocio;

import java.util.List;

import com.integrador.model.ResultadoMovimiento;

public interface MovimientoBll {
	public List<ResultadoMovimiento> getResultadosMovimientosCuenta(int cuentaId );
}
