package com.integrador.model;

public class Movimiento {
	private int movimientoID;
	private double importe;
	private String detalle;
	private int tipoMovimientoID;
	
	public Movimiento(double importe, String detalle, int tipoMovimientoID) {
		this.importe = importe;
		this.detalle = detalle;
		this.tipoMovimientoID = tipoMovimientoID;
	}
	
	public Movimiento() {
	}
	
	public int getMovimientoId(){
		return movimientoID;
	}
	
	public double getImporte(){
		return importe;
	}

	public void setImporte(double importe){
		this.importe = importe;
	}

	public String getDetalle(){
		return detalle;
	}

	public void setDetalle(String detalle){
		this.detalle = detalle;
	}

	public int getTipomovimientoid(){
		return tipoMovimientoID;
	}

	public void setTipomovimientoid(int tipoMovimientoID){
		this.tipoMovimientoID = tipoMovimientoID;
	}
}