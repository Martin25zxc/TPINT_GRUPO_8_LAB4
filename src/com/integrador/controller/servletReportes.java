package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletReportes
 */
@WebServlet("/Reportes/*")
public class servletReportes extends servletBaseIntegrador  {
	
	private static final long serialVersionUID = -9198826362341668920L;
	
	private final String viewReportes = "/views/Reportes/reportesListado.jsp";
	
    public servletReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!this.isLogged(request)) {
			this.redirectToLogin(request, response);
		} else {
			String action = getCurrentAction(request);
			if (action != null) {
				switch (action) {
				case "/listado": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewReportes);
					dispatcher.forward(request, response);
					break;
				}
				default:
					this.redirectToHome(request, response);
					break;
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
