package com.integrador.customExceptions;

import java.util.HashMap;
import java.util.Map;

public class MoneyTransactionException extends Exception {
	private static final long serialVersionUID = 472597733118989816L;
	private Map<Integer,String> IdCuentasInvolucradas = new HashMap<Integer,String>();
	private double importe = 0;

	public MoneyTransactionException() {
		super();
	}
	
	public MoneyTransactionException(double importe, HashMap<Integer,String> IdCuentasInvolucradas) {
		super();
		this.importe = importe;
		this.IdCuentasInvolucradas = IdCuentasInvolucradas;
	}
	
	public MoneyTransactionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public MoneyTransactionException(String arg0) {
		super(arg0);
	}
	
	public MoneyTransactionException(Throwable arg0) {
		super(arg0);
	}
	
	public Map<Integer,String> getIdCuentasInvolucradas() {
		return IdCuentasInvolucradas;
	}
	
	public void setIdCuentasInvolucradas(HashMap<Integer,String> idCuentasInvolucradas) {
		IdCuentasInvolucradas = idCuentasInvolucradas;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
}
