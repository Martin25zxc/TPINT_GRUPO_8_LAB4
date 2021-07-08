package com.integrador.model;

public class PermisoUsuario {

	private int permisoUsuarioI;
	private int usuarioId;
	private int permisoId;
	
	public PermisoUsuario() 
	{
		
	}

	public PermisoUsuario(int permisoUsuarioI, int usuarioId, int permisoId) {
		this.permisoUsuarioI = permisoUsuarioI;
		this.usuarioId = usuarioId;
		this.permisoId = permisoId;
	}

	public int getPermisoUsuarioI() {
		return permisoUsuarioI;
	}

	public void setPermisoUsuarioI(int permisoUsuarioI) {
		this.permisoUsuarioI = permisoUsuarioI;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getPermisoId() {
		return permisoId;
	}

	public void setPermisoId(int permisoId) {
		this.permisoId = permisoId;
	}
	
	
	
}
