package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.model.AlertMessage;
import com.integrador.model.Usuario;
import com.integrador.negocio.UsuarioBll;
import com.integrador.negocioImpl.UsuarioBllImpl;

/**
 * Servlet implementation class servletHome
 */
@WebServlet("/Home")
public class servletHome extends servletBaseIntegrador {
	private static final long serialVersionUID = 1L;
	private UsuarioBll usuarioBll;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletHome() {
        super();
        usuarioBll = new UsuarioBllImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!this.isLogged(request))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/views/Home/login.jsp");   
	        rd.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home/index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnAceptar") != null) {
			try {
				String nombre = request.getParameter("txtNombreUsuario");
				String contrasenia = request.getParameter("txtContrasenia");
				
				Usuario usuario = usuarioBll.autenticar(nombre, contrasenia);
				
				request.getSession().setAttribute("UsuarioLogueado",usuario);
				request.getSession().setAttribute("TipoUsuarioLogueado",usuario.getTipousuarioId());
				request.getSession().setAttribute("NombreUsuarioLogueado",usuario.getNombreusuario());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home/index.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				
				AlertMessage a = new AlertMessage("Alert",e.getMessage());
				request.setAttribute("alertMessage",a);
				doGet(request,response);
			}
		}
	}

}
