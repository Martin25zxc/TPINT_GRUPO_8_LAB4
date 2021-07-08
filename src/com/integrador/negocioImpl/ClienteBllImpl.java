package com.integrador.negocioImpl;

import java.util.List;

import com.integrador.dao.ClienteDao;
import com.integrador.daoImpl.ClienteDaoImpl;
import com.integrador.model.Cliente;
import com.integrador.negocio.ClienteBll;

public class ClienteBllImpl implements ClienteBll {
	private ClienteDao clienteDao;
	
	public ClienteBllImpl() {
		clienteDao = new ClienteDaoImpl();
	}
	
	@Override
	public int post(Cliente cliente) throws BusinessException {
		int r = clienteDao.post(cliente);
		return r;
	}

	@Override
	public boolean update(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws BusinessException {
		
		return false;
	}

	@Override
	public Cliente get(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> get(){
		return clienteDao.get();
	}

}
