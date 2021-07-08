package com.integrador.negocioImpl;

import com.integrador.dao.UsuarioDao;
import com.integrador.daoImpl.UsuarioDaoImpl;
import com.integrador.model.Usuario;
import com.integrador.negocio.UsuarioBll;

public class UsuarioBllImpl implements UsuarioBll{
	private UsuarioDao usuarioDao;
	
	public UsuarioBllImpl() {
		usuarioDao = new UsuarioDaoImpl();
	}

	@Override
	public Usuario autenticar(String userName, String contrasenia) throws Exception {
		Usuario user = usuarioDao.autenticar(userName, contrasenia);
		if(user != null) return user;
		else {
			throw new Exception("El usuario y contraseña no coinciden.");
		}
	}

}
