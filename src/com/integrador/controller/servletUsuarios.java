package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.utilities.StringHelper;

/**
 * Servlet implementation class servletUsuarios
 */
@WebServlet("/Usuarios/*")
public class servletUsuarios extends servletBaseIntegrador {
	private static final long serialVersionUID = 1L;
	private final String viewUsuarioPerfil = "/views/Usuarios/usuariosProfile.jsp";    


    public servletUsuarios() {
        super();
        // TODO Auto-generated constructor stub
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
			String action = getCurrentAction(request);
			if(action!=null)
			{
				if(StringHelper.isNumeric(action.substring(1))) {
					action = "/get";
				}
				switch (action) {
					case "/get":
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewUsuarioPerfil); 
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
