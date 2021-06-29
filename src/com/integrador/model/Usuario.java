package com.integrador.model;

public class Usuario {
	private int usuarioId;
	private String nombreUsuario;
	private String contrasenia;
	private String email;
	private String descripcion;
	private int tipoUsuarioId;
	private boolean activo;
	
	public Usuario(String nombreUsuario, String contrasenia, String email, String descripcion, int tipoUsuarioID, boolean activo) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.email = email;
		this.descripcion = descripcion;
		this.tipoUsuarioId = tipoUsuarioID;
		this.activo = activo;
	}
	
	public int getUsuarioId(){
		return usuarioId;
	}
	
	public String getNombreusuario(){
		return nombreUsuario;
	}

	public void setNombreusuario(String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia(){
		return contrasenia;
	}

	public void setContrasenia(String contrasenia){
		this.contrasenia = contrasenia;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	public int getTipousuarioid(){
		return tipoUsuarioId;
	}

	public void setTipousuarioid(int tipoUsuarioId){
		this.tipoUsuarioId = tipoUsuarioId;
	}
	
	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}