package com.integrador.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletCuentas
 */
@WebServlet("/Cuentas/*")
public class servletCuentas extends HttpServlet {
	
	private static final long serialVersionUID = 5504794695107506806L;
	
	private final String viewClienteAlta = "/views/Clientes/clientesAlta.jsp";
	private final String viewClienteListado = "/views/Clientes/clientesListado.jsp";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = (request.getPathInfo()).toLowerCase();
		response.getWriter().append("Served at: ").append(request.getContextPath()+request.getServletPath()+" s  "+path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
