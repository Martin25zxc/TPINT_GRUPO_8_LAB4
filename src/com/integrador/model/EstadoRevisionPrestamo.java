package com.integrador.model;
public class EstadoRevisionPrestamo {

	private int estadoRevisionPrestamoId;
	private String nombre;
	private String descripcion;
	

	public EstadoRevisionPrestamo(){
		
	}
	
	public EstadoRevisionPrestamo(int estadoRevisionPrestamo, String nombre, String descripcion) {
		
		this.estadoRevisionPrestamoId = estadoRevisionPrestamo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public int getEstadoRevisionPrestamo() {
		return estadoRevisionPrestamoId;
	}
	
	public void setEstadoRevisionPrestamo(int estadoRevisionPrestamo) {
		this.estadoRevisionPrestamoId = estadoRevisionPrestamo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
