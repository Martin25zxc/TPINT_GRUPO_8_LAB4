package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.model.Usuario;

public abstract class servletBaseIntegrador extends HttpServlet {

	private static final long serialVersionUID = -3681892019396850035L;
	
	public servletBaseIntegrador () {
		super();
	}
	
	protected boolean isLogged(HttpServletRequest request) {
		
		String user =(String)request.getSession().getAttribute("NombreUsuarioLogueado");
		return user != null;
	}
	
	protected void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		response.sendRedirect(request.getContextPath() + "/Home");
	}
	
	protected Usuario GetUsuarioLogueado(HttpServletRequest request) {
		
		Usuario user =((Usuario)(request.getSession().getAttribute("UsuarioLogueado")));
		return user;
	}
}
