package com.integrador.negocioImpl;

import java.util.List;

import com.integrador.customExceptions.BusinessException;
import com.integrador.dao.ClienteDao;
import com.integrador.dao.CuentaDao;
import com.integrador.daoImpl.ClienteDaoImpl;
import com.integrador.daoImpl.CuentaDaoImpl;
import com.integrador.model.Cliente;
import com.integrador.model.Cuenta;
import com.integrador.model.TipoCuenta;
import com.integrador.negocio.CuentaBll;
import com.integrador.utilities.StringHelper;

public class CuentaBllImpl implements CuentaBll {

	private CuentaDao cuentaDao;
	private ClienteDao clienteDao;

	public CuentaBllImpl() {
		cuentaDao = new CuentaDaoImpl();
		clienteDao = new ClienteDaoImpl();
	}

	@Override
	public void post(Cuenta cuenta) throws BusinessException {
		String errores = validacionesAlta(cuenta);
		if (!StringHelper.isNullOrWhitespace(errores))
			throw new BusinessException(errores);

		generarCBUNumeroCuentaAlias(cuenta);

		if (!cuentaDao.post(cuenta))
			throw new BusinessException("No se pudo agregar el registro.");
	}

	@Override
	public void delete(int id) throws BusinessException {
		Cuenta cuenta = null;
		cuenta = cuentaDao.get(id);
		if (cuenta == null)
			throw new BusinessException("No se encontr� la cuenta solicitada.");

		if (!cuentaDao.delete(id))
			throw new BusinessException("No se pudo borrar el registro.");
	}

	@Override
	public void activate(int id) throws BusinessException {
		Cuenta cuenta = null;
		cuenta = cuentaDao.get(id);
		if (cuenta == null)
			throw new BusinessException("No se encontr� la cuenta solicitada.");

		String errores = validacionCuentasActivasCliente(cuenta.getClienteId());
		if (!StringHelper.isNullOrWhitespace(errores))
			throw new BusinessException(errores);

		if (!cuentaDao.activate(id))
			throw new BusinessException("No se pudo activar el registro.");
	}

	@Override
	public Cuenta get(int id) throws BusinessException {
		Cuenta cuenta = null;
		cuenta = cuentaDao.get(id);
		
		if (cuenta == null)
			throw new BusinessException("No se encontr� la cuenta solicitada.");
		
		return cuenta;
	}
	
	@Override
	public Cuenta getByCBU(String cbu) throws BusinessException {
		Cuenta cuenta = null;
		cuenta = cuentaDao.getByCBU(cbu);
		
		if (cuenta == null)
			throw new BusinessException("No se encontr� la cuenta solicitada.");
		
		return cuenta;
	}

	@Override
	public Cuenta getByAlias(String alias) throws BusinessException {
		Cuenta cuenta = cuentaDao.getByAlias(alias);
		if (cuenta == null)
			throw new BusinessException("No se encontro la cuenta solicitada");
		return cuenta;
	}
	
	/**
	 * Metodo que retorna una lista de cuentas segun los parametros que reciba
	 * 
	 * @param estado
	 *            si no es "" buscara por T(True) o F (false)
	 * @param clienteId
	 *            si se pasa un cliente id que no sea 0 se filtrara por el id del
	 *            cliente.
	 */
	@Override
	public List<Cuenta> get(String estado, int clienteId) {

		return cuentaDao.get(estado, clienteId);
	}

	@Override
	public List<TipoCuenta> getTiposCuentas() {
		return cuentaDao.getTiposCuentas();
	}
	
	@Override
	public void updateAlias(int id, String alias) throws BusinessException{
			String errores = validateUpdateAlias(id, alias);
			if(!StringHelper.isNullOrWhitespace(errores))
				throw new BusinessException(errores);
			if (!cuentaDao.updateAlias(id, alias))
				throw new BusinessException("No se pudo cambiar el alias.");	
	}

	private String validacionesAlta(Cuenta cuenta) {
		String errores = "";
		int clienteId = cuenta.getClienteId();
		Cliente cliente = clienteDao.get(clienteId);
		if (cliente == null) {
			errores += "No se encontro al cliente especificado";
		} else {
			if (!cliente.isActive())
				errores = "El cliente se encuentra desactivado";
			errores += validacionCuentasActivasCliente(clienteId);
		}

		if (cuenta.getTipoCuentaId() == 0)
			errores = "Se debe ingresar un tipo de cuenta";

		return errores;
	}

	private String validacionCuentasActivasCliente(int clienteId) {
		String errores = "";
		List<Cuenta> cuentasActivasDelCliente = cuentaDao.get("T", clienteId);
		if (cuentasActivasDelCliente != null && cuentasActivasDelCliente.size() >= 3)
			errores = "El cliente no puede tener mas de 3 cuentas activas";
		return errores;
	}

	private void generarCBUNumeroCuentaAlias(Cuenta cuenta) throws BusinessException {
		try {
			String cbu = "";
			String codigoDelBanco = "333";
			int length = 13;
			Cuenta ultima = cuentaDao.getUltima();
			int ultimoId = ultima == null ? 0 : ultima.getCuentaId();
			String codigoSucursal = "0011";
			String digitoDeControl1 = "3";
			String numeroCuenta = StringHelper.padLeft(length, Integer.toString(ultimoId + 1), '0');
			String digitoDeControl2 = "1";
			cbu += codigoDelBanco + codigoSucursal + digitoDeControl1 + numeroCuenta + digitoDeControl2;
			String alias = numeroCuenta.substring(numeroCuenta.length() - 3, numeroCuenta.length()) + "."
					+ StringHelper.padLeft(3, Integer.toString(cuenta.getClienteId()), '0') + "."
					+ StringHelper.reverseString(numeroCuenta.substring(0, 3));

			cuenta.setAlias(alias);
			cuenta.setCBU(cbu);
			cuenta.setNumeroDeCuenta(numeroCuenta);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Se produjo un error al intentar generar el CBU, Nro Cuenta y Alias");
		}
	}

	private String validateUpdateAlias(int id, String alias) {
		String errores = "";
		Cuenta cuenta = cuentaDao.get(id);
		if (StringHelper.isNullOrWhitespace(alias))
			errores += "El alias no puede ser nulo o vacio";
		if (cuenta == null)
			errores = "No se encontro la cuenta solicitada";

		if (alias.length() > 20)
			errores += "El alias no puede ser mayor a 20 caracteres";

		Cuenta cuenta2 = cuentaDao.getByAlias(alias);
		if (cuenta2 != null && cuenta2.getCuentaId() != id)
			errores += "El alias ya existe";

		return errores;
	}
}
