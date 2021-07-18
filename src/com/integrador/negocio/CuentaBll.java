package com.integrador.negocio;

import java.util.List;

import com.integrador.customExceptions.BusinessException;
import com.integrador.model.Cuenta;
import com.integrador.model.TipoCuenta;

public interface CuentaBll {
	public void post (Cuenta cuenta) throws BusinessException;
	public void delete (int id) throws BusinessException;
	public void activate (int id) throws BusinessException;
	public void updateAlias(int id, String alias) throws BusinessException;
	public Cuenta get(int id) throws BusinessException;
	Cuenta getByCBU(String cbu) throws BusinessException;
	Cuenta getByAlias(String alias) throws BusinessException;
	/**
	 * Metodo que retorna una lista de cuentas segun los parametros que reciba
	 * @param estado si no es "" buscara por T(True) o F (false)
	 * @param clienteId si se pasa un cliente id que no sea 0 se filtrara por el id del cliente.
	 */
	public List<Cuenta> get(String estado , int clienteId );
	public List<TipoCuenta> getTiposCuentas();
}
