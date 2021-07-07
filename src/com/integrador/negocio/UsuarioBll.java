package com.integrador.negocio;

import com.integrador.model.Usuario;

public interface UsuarioBll {
	Usuario autenticar (String userName , String contrasenia) throws Exception;
}
