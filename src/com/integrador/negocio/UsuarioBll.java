package com.integrador.negocio;

import com.integrador.customExceptions.BusinessException;
import com.integrador.model.Usuario;

public interface UsuarioBll {
	Usuario autenticar (String userName , String contrasenia) throws BusinessException;
	Usuario get(int id) throws BusinessException;
	public void cambioContrasenia (int usuarioId, String contrasenia) throws BusinessException;
}
