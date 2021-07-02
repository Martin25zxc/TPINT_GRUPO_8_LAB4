package com.integrador.dao;

import java.util.List;

import com.integrador.model.Cliente;

public interface ClienteDao {
	public int post (Cliente cliente);
	public int update (Cliente cliente);
	public int delete (int id);
	public Cliente get(int id);
	public List<Cliente> get();
}
