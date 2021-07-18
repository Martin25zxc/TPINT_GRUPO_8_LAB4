package com.integrador.model;

import java.time.LocalDate;

import com.integrador.utilities.StringHelper;

public class Cuenta {
	private int cuentaId;
	private int clienteId;
	private String numeroDeCuenta;
	private String CBU;
	private String alias;
	private int bancoId;
	private int tipoCuentaId;
	private boolean activo;
	private LocalDate fechaAlta;
	
	private Cliente cliente;
	private TipoCuenta tipoCuenta;
	
	private double saldo;
	
	public Cuenta(int clienteId, String numeroDeCuenta, String cBU, String alias, int bancoId, int tipoCuentaId, boolean activo) {
		this.clienteId = clienteId;
		this.numeroDeCuenta = numeroDeCuenta;
		CBU = cBU;
		this.alias = alias;
		this.bancoId = bancoId;
		this.tipoCuentaId = tipoCuentaId;
		this.activo = activo;
	}
	
	public Cuenta() {
	}
	
	public int getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getNumeroDeCuenta(){
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String NumeroDeCuenta){
		this.numeroDeCuenta=NumeroDeCuenta;
	}

	public String getCBU(){
		return CBU;
	}

	public void setCBU(String CBU){
		this.CBU=CBU;
	}

	public String getAlias(){
		return alias;
	}

	public void setAlias(String alias){
		this.alias=alias;
	}

	public int getBancoId(){
		return bancoId;
	}

	public void setBancoId(int bancoId){
		this.bancoId=bancoId;
	}
	
	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getTipoCuentaId() {
		return tipoCuentaId;
	}

	public void setTipoCuentaId(int tipoCuentaId) {
		this.tipoCuentaId = tipoCuentaId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String saldoString() {
		String saldoFormat = StringHelper.formatDecimal(this.saldo);
		return saldoFormat;
	}
	
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}