package com.integrador.model;

public class Banco{
	private int bancoId;
	private String nombre;
	private String descripcion;
	
	public Banco(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Banco() {
	}

	public int getBancoId(){
		return bancoId;
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