package com.integrador.model;
public class TipoUsuario {
	private int tipoUsuarioId;
	private String nombre;
	private String descripcion;

	public TipoUsuario(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public int getTipoUsuario(){
		return tipoUsuarioId;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
}