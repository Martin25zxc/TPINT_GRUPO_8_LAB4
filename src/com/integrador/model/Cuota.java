package com.integrador.model;

import java.util.Date;

public class Cuota {
	private int cuotaId;
	private double importe;
	private Date fechaAlta;
	private Date fechaPago;
	private int numeroCuota;
	private int prestamoId;

	public Cuota() {

	}

	public Cuota(int cuotaId, float importe, Date fechaAlta, Date fechaPago, int numeroCuota, int prestamoId) {
		this.cuotaId = cuotaId;
		this.importe = importe;
		this.fechaAlta = fechaAlta;
		this.fechaPago = fechaPago;
		this.numeroCuota = numeroCuota;
		this.prestamoId = prestamoId;
	}
	// setters and getters

	public int getCuotaId() {
		return cuotaId;
	}

	public void setCuotaId(int cuotaId) {
		this.cuotaId = cuotaId;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public int getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}

}
