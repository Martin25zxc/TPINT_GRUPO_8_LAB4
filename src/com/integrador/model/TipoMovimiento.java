package com.integrador.model;

public class TipoMovimiento {
	private int tipoMovimientoId;
	private String nombre;
	private String descripcion;
	
	public TipoMovimiento(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public int getTipoMovimientoId(){
		return tipoMovimientoId;
	}
	
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String Nombre){
		this.nombre = Nombre;
	}

	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String Descripcion){
		this.descripcion = Descripcion;
	}
}