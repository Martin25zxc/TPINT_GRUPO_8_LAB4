package com.integrador.negocio;

import java.util.List;

import com.integrador.model.Cliente;
import com.integrador.negocioImpl.BusinessException;

public interface ClienteBll {
	public void post (Cliente cliente) throws BusinessException;
	public void update (Cliente cliente) throws BusinessException;
	public void delete (int id) throws BusinessException;
	public Cliente get(int id) throws BusinessException;
	public List<Cliente> get();
}
