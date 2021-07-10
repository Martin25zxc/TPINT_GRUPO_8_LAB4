package com.integrador.model;

import java.time.LocalDate;

public class Usuario {
	private int usuarioId;
	private String nombreUsuario;
	private String contrasenia;
	private String email;
	private String descripcion;
	private String tipoUsuarioId;
	private boolean activo;
	private LocalDate fechaAlta;
	
	private Cliente cliente;
	
	public Usuario(String nombreUsuario, String contrasenia, String email, String descripcion, String tipoUsuarioID, boolean activo, LocalDate fechaAlta) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.email = email;
		this.descripcion = descripcion;
		this.tipoUsuarioId = tipoUsuarioID;
		this.activo = activo;
		this.cliente = null;
		this.fechaAlta = fechaAlta;
	}
	
	public Usuario() {
	}
	
	public int getUsuarioId(){
		return usuarioId;
	}
	
	public void setUsuarioId(int id){
		this.usuarioId = id;
	}
	
	public String getNombreUsuario(){
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario){
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
	
	public String getTipoUsuarioId(){
		return tipoUsuarioId;
	}

	public void setTipousuarioId(String tipoUsuarioId){
		this.tipoUsuarioId = tipoUsuarioId;
	}
	
	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}