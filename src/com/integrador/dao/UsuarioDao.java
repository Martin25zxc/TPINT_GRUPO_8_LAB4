package com.integrador.dao;

import com.integrador.model.Usuario;

public interface UsuarioDao {
	Usuario autenticar (String userName , String contrasenia);
	boolean cambioContrasenia (int usuarioId , String contrasenia);
	Usuario get(int id);
}
