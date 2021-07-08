package com.integrador.dao;

import java.util.List;

import com.integrador.model.Cliente;

public interface ClienteDao {
	public boolean post (Cliente cliente);
	public boolean update (Cliente cliente);
	public boolean delete (int id);
	public Cliente get(int id);
	public List<Cliente> get();
}
