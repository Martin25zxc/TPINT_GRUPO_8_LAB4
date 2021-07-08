package com.integrador.model;

public class ResultadoMovimiento {

	private int resultadoMovimientoId; 
	private double importe;	
	private String detalle;
	private int movimientoId;
	private int usuarioId;

	public ResultadoMovimiento()
	{
		
	}

	public ResultadoMovimiento(int resultadoMovimientoId, double importe, String detalle, int movimientoId,
			int usuarioId) {
		super();
		this.resultadoMovimientoId = resultadoMovimientoId;
		this.importe = importe;
		this.detalle = detalle;
		this.movimientoId = movimientoId;
		this.usuarioId = usuarioId;
	}

		// Setter and Getters
	public int getResultadoMovimientoId() {
		return resultadoMovimientoId;
	}

	public void setResultadoMovimientoId(int resultadoMovimientoId) {
		this.resultadoMovimientoId = resultadoMovimientoId;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getMovimientoId() {
		return movimientoId;
	}

	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	

	
}
