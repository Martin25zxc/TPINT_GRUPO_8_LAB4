package com.integrador.negocioImpl;

import java.time.LocalDate;
import java.util.List;

import com.integrador.dao.ClienteDao;
import com.integrador.daoImpl.ClienteDaoImpl;
import com.integrador.model.Cliente;
import com.integrador.negocio.ClienteBll;
import com.integrador.utilities.DateHelper;
import com.integrador.utilities.StringHelper;

public class ClienteBllImpl implements ClienteBll {
	private ClienteDao clienteDao;
	
	public ClienteBllImpl() {
		clienteDao = new ClienteDaoImpl();
	}
	
	@Override
	public void post(Cliente cliente) throws BusinessException {
		String errores = validacionesAlta(cliente);
		if( !StringHelper.isNullOrWhitespace(errores))
			throw new BusinessException(errores);
		
		if(!clienteDao.post(cliente))
			throw new BusinessException("No se pudo agregar el registro.");
	}

	@Override
	public void update(Cliente cliente) throws BusinessException {
		Cliente reg = null;
		reg = clienteDao.get(cliente.getClienteId());
		if (reg == null)
			throw new BusinessException("No se encontró al Cliente solicitado.");
		
		if(!clienteDao.update(cliente))
			throw new BusinessException("No se pudo actualizar el registro.");
	}

	@Override
	public void delete(int id) throws BusinessException {
		Cliente cliente = null;
		cliente = clienteDao.get(id);
		if (cliente == null)
			throw new BusinessException("No se encontró al Cliente solicitado.");
		
		if(!clienteDao.delete(id))
			throw new BusinessException("No se pudo borrar el registro.");
	}

	@Override
	public Cliente get(int id) throws BusinessException {
		Cliente cliente = null;
		cliente = clienteDao.get(id);
		
		if (cliente == null)
			throw new BusinessException("No se encontró al Cliente solicitado.");
		
		return cliente;
	}

	@Override
	public List<Cliente> get(){
		return clienteDao.get();
	}
	
	private String validacionesAlta(Cliente cliente)
	{
		String errores = "";
		if(cliente.getUsuario() == null)
		{
			errores += "No se agregaron los datos para registrar el usuario";
			String contrasenia = cliente.getUsuario().getContrasenia();
			if(StringHelper.isNullOrWhitespace(contrasenia))
			{
				errores += "No se registro la contraseña.";
			}
			else if(contrasenia.length() <= 4)
			{
				errores += "La contraseña tiene que tener 5 o mas caracteres.";
			}
			
			String nombreUsuario = cliente.getUsuario().getNombreusuario();
			if(StringHelper.isNullOrWhitespace(nombreUsuario))
			{
				errores += "No se registro la nombre de usuario.";
			}
			else if(contrasenia.length() <= 4)
			{
				errores += "El nombre de usuario tiene que tener 5 o mas caracteres.";
			}
		}
		
		String email = cliente.getEmail();
		if(StringHelper.isNullOrWhitespace(email))
		{
			errores += "No se registro el e-mail.";
		}
		
		String nombre = cliente.getNombre();
		if(StringHelper.isNullOrWhitespace(nombre))
		{
			errores += "No se registro el nombre.";
		}
		
		String apellido = cliente.getApellido();
		if(StringHelper.isNullOrWhitespace(apellido))
		{
			errores += "No se registro el e-mail.";
		}
		
		String nacionalidad = cliente.getNacionalidad();
		if(StringHelper.isNullOrWhitespace(nacionalidad))
		{
			errores += "No se registro la nacionalidad.";
		}
		
		String nroDocumento = cliente.getNrodocumento();
		if(StringHelper.isNullOrWhitespace(nroDocumento))
		{
			errores += "No se registro el nro de documento.";
		}
		
		LocalDate hoy = LocalDate.now();
		LocalDate fechaNacimiento = cliente.getFechaNacimiento();
		int edad = DateHelper.calculateAge(fechaNacimiento, hoy);
		if(edad < 18) {
			errores += "El cliente tiene que ser mayor de edad.";
		}
		
		return errores;
	}

}
