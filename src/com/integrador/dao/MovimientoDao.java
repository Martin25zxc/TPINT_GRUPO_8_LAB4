package com.integrador.dao;

import java.util.List;

import com.integrador.model.ResultadoMovimiento;
public interface MovimientoDao {
	List<ResultadoMovimiento> getResultadosMovimientosCuenta(int cuentaId);
	Boolean hacerTransferencia(int cuentaIdOrigen, int cuentaIdDestino, double monto);
	Boolean hacerDeposito(int cuentaId, double monto);
	Boolean hacerRetiro(int cuentaId, double monto);
}
