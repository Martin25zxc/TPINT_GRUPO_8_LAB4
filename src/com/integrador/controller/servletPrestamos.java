package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletPrestamos
 */
@WebServlet("/Prestamos/*")
public class servletPrestamos extends servletBaseIntegrador {

	private static final long serialVersionUID = 5181272060821155918L;
	
	private final String viewPrestamosPago= "/views/Prestamos/prestamosPago.jsp";	
	private final String viewPrestamosSolicitar = "/views/Prestamos/prestamosSolicitar.jsp";	
	private final String viewPrestamosListado = "/views/Prestamos/prestamosListado.jsp";	
	
    public servletPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!this.isLogged(request)) {
			this.redirectToLogin(request, response);
		} else {
			String action = getCurrentAction(request);
			if (action != null) {
				switch (action) {
				case "/pagar": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPrestamosPago);
					dispatcher.forward(request, response);
					break;
				}
				case "/solicitar": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPrestamosSolicitar);
					dispatcher.forward(request, response);
					break;
				}
				case "/listado": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewPrestamosListado);
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
