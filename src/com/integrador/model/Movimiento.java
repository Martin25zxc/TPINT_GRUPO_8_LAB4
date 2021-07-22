package com.integrador.model;

import java.time.LocalDate;

public class Movimiento {
	private int movimientoId;
	private double importe;
	private String detalle;
	private int tipoMovimientoId;
	private LocalDate fechaAlta;
	private TipoMovimiento tipoMovimiento;
	
	public Movimiento(double importe, String detalle, int tipoMovimientoId, LocalDate fechaAlta) {
		this.importe = importe;
		this.detalle = detalle;
		this.tipoMovimientoId = tipoMovimientoId;
		this.fechaAlta = fechaAlta;
		this.tipoMovimiento = new TipoMovimiento();
	}
	
	public Movimiento() {
	}
	
	public void setMovimientoId(int movimientoId) {
		this.movimientoId = movimientoId;
	}
	
	public int getMovimientoId(){
		return movimientoId;
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

	public int getTipoMovimientoId() {
		return tipoMovimientoId;
	}

	public void setTipoMovimientoId(int tipoMovimientoId) {
		this.tipoMovimientoId = tipoMovimientoId;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
}