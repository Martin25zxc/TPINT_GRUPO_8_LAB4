package com.integrador.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.model.Cliente;
import com.integrador.model.Usuario;
import com.integrador.negocio.ClienteBll;
import com.integrador.negocioImpl.ClienteBllImpl;
import com.integrador.utilities.DateHelper;
import com.integrador.utilities.StringHelper;

/**
 * Servlet implementation class servletClientes
 */
@WebServlet("/Clientes/*")
public class servletClientes extends servletBaseIntegrador {

	private static final long serialVersionUID = -4717208001910999086L;
	
	private ClienteBll clienteBll;
	private final String viewClienteAlta = "/views/Clientes/clientesAlta.jsp";
	private final String viewClienteListado = "/views/Clientes/clientesListado.jsp";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public servletClientes() {
        super();
        clienteBll = new ClienteBllImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!this.isLogged(request))
		{
			this.redirectToLogin(request, response);
		}
		else {
			String action = getCurrentAction(request);
			if(action!=null)
			{
				switch (action) {
					case "/alta":
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteAlta); 
						dispatcher.forward(request, response);
						break;
					}
					case "/listado":
					{
						request.setAttribute("lista", clienteBll.get());	
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteListado);
						dispatcher.forward(request, response);
						break;
					}
					default:
						response.sendRedirect("Home");
						break;
				}
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnAceptar") != null) {
			try {
				String contrasenia = request.getParameter("txtContrasenia");
				String contraseniaARepetir =  request.getParameter("txtContraseniaRepetir");
				if(StringHelper.isNullOrWhitespace(contrasenia))
				{
					throw new IOException("Las constraseña es inválida.");
				}
				
				if(!contrasenia.equals(contraseniaARepetir))
				{
					throw new IOException("Las constraseñas no coinciden.");
				}
				
				Cliente cliente = new Cliente();
				cliente.setNombre(request.getParameter("txtNombre"));
				cliente.setApellido(request.getParameter("txtApellido"));

				String fechaNacimientoSinFormat = request.getParameter("txtFechaNacimiento");
			
				LocalDate date = DateHelper.LocalDateFormat(fechaNacimientoSinFormat);
				cliente.setFechaNacimiento(date);

				String email = request.getParameter("txtEmail");
				cliente.setEmail(email);
				cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
				cliente.setProvincia(request.getParameter("txtProvincia"));
				cliente.setLocalidad(request.getParameter("txtLocalidad"));
				cliente.setDireccion(request.getParameter("txtDireccion"));
				cliente.setNrodocumento(request.getParameter("txtNroDocumento"));
				cliente.setTelefono1(request.getParameter("txtTelefono1"));
				cliente.setTelefono2(request.getParameter("txtTelefono2"));
				
				Usuario usuario = new Usuario();
				usuario.setContrasenia(contrasenia);
				usuario.setEmail(email);
				usuario.setNombreusuario(request.getParameter("txtNombreUsuario"));
				cliente.setUsuario(usuario);
				
				this.clienteBll.post(cliente);
				
				this.addSuccessAlertMessage(request, "Se agrego correctamente el registro.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home/index.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception ex) {
				ex.printStackTrace();
				this.addErrorAlertMessage(request, ex.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteAlta); 
				dispatcher.forward(request, response);
			}
		}
	}
	   
}
