package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.model.Cliente;
import com.integrador.negocio.ClienteBll;
import com.integrador.negocioImpl.ClienteBllImpl;

/**
 * Servlet implementation class servletClientes
 */
@WebServlet("/Clientes/*")
public class servletClientes extends servletBaseIntegrador {

	private static final long serialVersionUID = -4717208001910999086L;
	private ClienteBll clienteBll;
	private String viewClienteAlta = "/views/Clientes/clientesAlta.jsp";
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public servletClientes() {
        super();
        clienteBll = new ClienteBllImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!this.isLogged(request))
		{
			this.redirectToLogin(request, response);
		}
		else {
			String action = request.getPathInfo();
			if(action!=null)
			{
				action= action.toLowerCase();
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
						RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Clientes/clientesListado.jsp");
						dispatcher.forward(request, response);
						break;
					}
					default:
						response.sendRedirect("/Home");
						break;
				}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
	    {
	    	Cliente x = new Cliente();
	    	x.setNombre(request.getParameter("txtApellido"));
	    	
	    	request.setAttribute("responseState", "validate");
	    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteAlta);
			dispatcher.forward(request, response);
	    }
	}
	   
}
