package com.integrador.model;

public class Permiso {

	private int permisoId;
	private String nombre;
	private String descripcion;
	private String tags;
	
	//Constructores
	public Permiso()
	{
		
	}
	
	public Permiso(int permisoId, String nombre, String descripcion, String tags) {
		super();
		this.permisoId = permisoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tags = tags;
	}
   // Setters and Getters
	public int getPermisoId() {
		return permisoId;
	}

	public void setPermisoId(int permisoId) {
		this.permisoId = permisoId;
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
		
	
}
