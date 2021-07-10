package com.integrador.negocioImpl;

import java.time.LocalDate;

import com.integrador.customExceptions.BusinessException;
import com.integrador.dao.UsuarioDao;
import com.integrador.daoImpl.UsuarioDaoImpl;
import com.integrador.model.Cliente;
import com.integrador.model.Usuario;
import com.integrador.negocio.UsuarioBll;
import com.integrador.utilities.DateHelper;
import com.integrador.utilities.StringHelper;

public class UsuarioBllImpl implements UsuarioBll{
	private UsuarioDao usuarioDao;
	
	public UsuarioBllImpl() {
		usuarioDao = new UsuarioDaoImpl();
	}

	@Override
	public Usuario autenticar(String userName, String contrasenia) throws BusinessException {
		Usuario user = usuarioDao.autenticar(userName, contrasenia);
		if (user == null)
			throw new BusinessException("El usuario y contraseña no coinciden.");

		if(!user.isActive())
			throw new BusinessException("El usuario se encuentra desactivado");
		
		if(user.getCliente() != null && !user.getCliente().isActive())
			throw new BusinessException("El cliente se encuentra desactivado");
		user.setContrasenia("");
		return user;
	}
	
	@Override
	public Usuario get(int id) throws BusinessException {
		Usuario user = usuarioDao.get(id);
		if (user == null)
				throw new BusinessException("No se encontró al Usuario solicitado.");
		user.setContrasenia("");
		return user;
	}
	
	@Override
	public void cambioContrasenia (int usuarioId, String contrasenia) throws BusinessException {
		String errores = validacionesCambioContrasenia(usuarioId,contrasenia);
		if( !StringHelper.isNullOrWhitespace(errores))
			throw new BusinessException(errores);
		
		if(!usuarioDao.cambioContrasenia(usuarioId,contrasenia))
			throw new BusinessException("No se pudo realizar el cambio de contraseña.");
	}
	
	private String validacionesCambioContrasenia(int usuarioId, String contrasenia)
	{
		String errores = "";
		contrasenia = contrasenia.trim();
		if(StringHelper.isNullOrWhitespace(contrasenia)){
			errores += "No se registro la contraseña.";
			
		}else if(contrasenia.length() <= 4){
			errores += "La contraseña tiene que tener 5 o mas caracteres.";
		}
		
		if(usuarioDao.get(usuarioId) == null)
			errores += "No se encontro al usuario especificado.";
		
		return errores;
	}
}
