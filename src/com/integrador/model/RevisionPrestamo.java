package com.integrador.model;
import java.util.Date;

public class RevisionPrestamo {

	private int revisionPrestamoId;
	private int usuarioIdRevision; 
	private int estadoRevisionPrestamoId;
	private int prestamoId;	
	private Date fecha;

	public RevisionPrestamo()
	{
		
	}

	public RevisionPrestamo(int revisionPrestamoId, int usuarioIdRevision, int estadoRevisionPrestamoId, int prestamoId,
			Date fecha) {
		this.revisionPrestamoId = revisionPrestamoId;
		this.usuarioIdRevision = usuarioIdRevision;
		this.estadoRevisionPrestamoId = estadoRevisionPrestamoId;
		this.prestamoId = prestamoId;
		this.fecha = fecha;
	}

	// Setters and Getters
	
	public int getRevisionPrestamoId() {
		return revisionPrestamoId;
	}

	public void setRevisionPrestamoId(int revisionPrestamoId) {
		this.revisionPrestamoId = revisionPrestamoId;
	}

	public int getUsuarioIdRevision() {
		return usuarioIdRevision;
	}

	public void setUsuarioIdRevision(int usuarioIdRevision) {
		this.usuarioIdRevision = usuarioIdRevision;
	}

	public int getEstadoRevisionPrestamoId() {
		return estadoRevisionPrestamoId;
	}

	public void setEstadoRevisionPrestamoId(int estadoRevisionPrestamoId) {
		this.estadoRevisionPrestamoId = estadoRevisionPrestamoId;
	}

	public int getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
