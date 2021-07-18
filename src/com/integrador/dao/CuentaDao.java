package com.integrador.dao;

import java.util.List;

import com.integrador.model.Cuenta;
import com.integrador.model.TipoCuenta;

public interface CuentaDao {
	public boolean post (Cuenta cuenta);
	public boolean delete (int id);
	public boolean activate (int id);
	public boolean updateAlias (int id, String alias);
	public Cuenta get(int id);
	public Cuenta getByAlias(String alias);
	public Cuenta getByCBU(String cbu);
	public Cuenta getUltima();
	/**
	 * Metodo que retorna una lista de cuentas segun los parametros que reciba
	 * @param estado si no es "" buscara por T(True) o F (false)
	 * @param clienteId si se pasa un cliente id que no sea 0 se filtrara por el id del cliente.
	 */
	public List<Cuenta> get(String estado , int clienteId );
	public List<TipoCuenta> getTiposCuentas();
}
