package com.integrador.negocio;

import java.util.List;

import com.integrador.model.Cliente;

public interface ClienteBll {
	public int post (Cliente cliente) throws Exception;
	public boolean update (Cliente cliente) throws Exception;
	public boolean delete (int id) throws Exception;
	public Cliente get(int id) throws Exception;
	public List<Cliente> get();
}
