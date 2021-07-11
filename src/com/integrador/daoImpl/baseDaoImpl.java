package com.integrador.daoImpl;

public abstract class baseDaoImpl {
	protected final String selectClienteCardQ = " clientes.ClienteID clientesClienteID ,clientes.FechaNacimiento clientesFechaNacimiento ,clientes.FechaAlta clientesFechaAlta ,clientes.Nombre clientesNombre ,clientes.Apellido clientesApellido ,clientes.Nacionalidad clientesNacionalidad ,clientes.Provincia clientesProvincia ,clientes.Direccion clientesDireccion ,clientes.Localidad clientesLocalidad ,clientes.Email clientesEmail ,clientes.NroDocumento clientesNroDocumento ,clientes.Telefono1 clientesTelefono1 ,clientes.Telefono2 clientesTelefono2 ,clientes.UsuarioID clientesUsuarioID ,clientes.Activo clientesActivo "; 
	protected final String selectUsuariosCardQ = " usuarios.UsuarioID usuariosUsuarioID , usuarios.NombreUsuario usuariosNombreUsuario , usuarios.Contrasenia usuariosContrasenia , usuarios.UserEmail usuariosUserEmail , usuarios.Descripcion usuariosDescripcion , usuarios.TipoUsuarioID usuariosTipoUsuarioID , usuarios.Activo usuariosActivo , usuarios.FechaAlta usuariosFechaAlta ";
}
