package com.integrador.controller;

import java.io.IOException;

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
	
	protected void redirectToHome(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		response.sendRedirect(request.getContextPath() + "/Home");
	}
	
	protected Usuario getUsuarioLogueado(HttpServletRequest request) {
		
		Usuario user =((Usuario)(request.getSession().getAttribute("UsuarioLogueado")));
		return user;
	}
	
	protected String getCurrentAction(HttpServletRequest request) {
		String actionName = request.getPathInfo();
		return actionName == null? null : actionName.toLowerCase();
	}
	
	protected void addErrorAlertMessage(HttpServletRequest request, String message) {
		request.getSession().setAttribute("alertErrorMessage",message);
	}
	
	protected void addInfoAlertMessage(HttpServletRequest request, String message) {
		request.getSession().setAttribute("alertInforMessage",message);
	}
	
	protected void addSuccessAlertMessage(HttpServletRequest request, String message) {
		request.getSession().setAttribute("alertSuccessMessage",message);
	}
	
	protected void addWarningAlertMessage(HttpServletRequest request, String message) {
		request.getSession().setAttribute("alertWarningMessage",message);
	}
}
