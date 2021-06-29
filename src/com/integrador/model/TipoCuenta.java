package com.integrador.model;

public class TipoCuenta {
	private String nombre;
	private String descripcion;
	
	public TipoCuenta(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String Nombre){
		this.nombre=Nombre;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String Descripcion){
		this.descripcion=Descripcion;
	}
}