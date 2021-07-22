package com.integrador.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletMovimientos
 */
@WebServlet("/Movimientos/*")
public class servletMovimientos extends servletBaseIntegrador {
	
	private static final long serialVersionUID = 237051155054015858L;

	private final String viewMovimientosTransferir= "/views/Movimientos/movimientosTransferir.jsp";	
	private final String viewMovimientosRetirar= "/views/Movimientos/movimientosRetirar.jsp";	
	private final String viewMovimientosDepositar= "/views/Movimientos/movimientosDepositar.jsp";	
	
    public servletMovimientos() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!this.isLogged(request)) {
			this.redirectToLogin(request, response);
		} else {
			String action = getCurrentAction(request);
			if (action != null) {
				switch (action) {
				case "/transferir": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewMovimientosTransferir);
					dispatcher.forward(request, response);
					break;
				}
				case "/depositar": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewMovimientosDepositar);
					dispatcher.forward(request, response);
					break;
				}
				case "/retirar": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewMovimientosRetirar);
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
