package com.integrador.model;
import java.util.Date;

public class Prestamo {

	private int prestamoId;
	private int clienteId;
	private Date fechaAlta;
	private double importeAPagarCliente;
	private double importePedidoCliente;
	private double montoPorCuota;
	private int plazo;
	
	public Prestamo()
	{
		
	}

	public Prestamo(int prestamoId, int clienteId, Date fechaAlta, double importeAPagarCliente,
			double importePedidoCliente, double montoPorCuota, int plazo) {
		super();
		this.prestamoId = prestamoId;
		this.clienteId = clienteId;
		this.fechaAlta = fechaAlta;
		this.importeAPagarCliente = importeAPagarCliente;
		this.importePedidoCliente = importePedidoCliente;
		this.montoPorCuota = montoPorCuota;
		this.plazo = plazo;
	}

	public int getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getImporteAPagarCliente() {
		return importeAPagarCliente;
	}

	public void setImporteAPagarCliente(double importeAPagarCliente) {
		this.importeAPagarCliente = importeAPagarCliente;
	}

	public double getImportePedidoCliente() {
		return importePedidoCliente;
	}

	public void setImportePedidoCliente(double importePedidoCliente) {
		this.importePedidoCliente = importePedidoCliente;
	}

	public double getMontoPorCuota() {
		return montoPorCuota;
	}

	public void setMontoPorCuota(double montoPorCuota) {
		this.montoPorCuota = montoPorCuota;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	
	
}
