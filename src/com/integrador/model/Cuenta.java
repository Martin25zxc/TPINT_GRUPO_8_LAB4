package com.integrador.model;

public class Cuenta {
	private int cuentaId;
	private int clienteId;
	private String numeroDeCuenta;
	private String CBU;
	private String alias;
	private int bancoId;
	private int tipoCuentaId;
	private boolean activo;
	
	public Cuenta(int clienteId, String numeroDeCuenta, String cBU, String alias, int bancoId, int tipoCuentaId, boolean activo) {
		this.clienteId = clienteId;
		this.numeroDeCuenta = numeroDeCuenta;
		CBU = cBU;
		this.alias = alias;
		this.bancoId = bancoId;
		this.tipoCuentaId = tipoCuentaId;
		this.activo = activo;
	}
	
	public int getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}

	public int getClienteid(){
		return clienteId;
	}

	public void setClienteid(int ClienteID){
		this.clienteId=ClienteID;
	}

	public String getNumerodecuenta(){
		return numeroDeCuenta;
	}

	public void setNumerodecuenta(String NumeroDeCuenta){
		this.numeroDeCuenta=NumeroDeCuenta;
	}

	public String getCbu(){
		return CBU;
	}

	public void setCbu(String CBU){
		this.CBU=CBU;
	}

	public String getAlias(){
		return alias;
	}

	public void setAlias(String Alias){
		this.alias=Alias;
	}

	public int getBancoid(){
		return bancoId;
	}

	public void setBancoid(int BancoID){
		this.bancoId=BancoID;
	}

	public int getTipocuentaid(){
		return tipoCuentaId;
	}

	public void setTipocuentaid(int TipoCuentaID){
		this.tipoCuentaId=TipoCuentaID;
	}
	
	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}