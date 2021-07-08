package com.integrador.negocioImpl;
import java.io.IOException;
public class BusinessException extends IOException {
	private static final long serialVersionUID = -2892419532443123476L;
	public BusinessException()
	{
		super();
	}
	
	public BusinessException(String message)
	{
		super(message);
	}		
}
