package com.integrador.negocio;

import java.util.List;

import com.integrador.model.Cliente;
import com.integrador.negocioImpl.BusinessException;

public interface ClienteBll {
	public int post (Cliente cliente) throws BusinessException;
	public boolean update (Cliente cliente) throws BusinessException;
	public boolean delete (int id) throws BusinessException;
	public Cliente get(int id) throws BusinessException;
	public List<Cliente> get();
}
