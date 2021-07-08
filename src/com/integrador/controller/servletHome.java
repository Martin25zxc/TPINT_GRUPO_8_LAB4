package com.integrador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.integrador.model.Usuario;
import com.integrador.negocio.UsuarioBll;
import com.integrador.negocioImpl.UsuarioBllImpl;
import com.integrador.utilities.StringHelper;

/**
 * Servlet implementation class servletHome
 */
@WebServlet("/Home/*")
public class servletHome extends servletBaseIntegrador {

	private static final long serialVersionUID = -2888702421809639600L;
	
	private UsuarioBll usuarioBll;
	private final String viewLogin = "/views/Home/login.jsp";
	private final String viewHomeIndex= "/views/Home/index.jsp";

    public servletHome() {
        super();
        usuarioBll = new UsuarioBllImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!this.isLogged(request))
		{
			RequestDispatcher rd = request.getRequestDispatcher(viewLogin);   
	        rd.forward(request, response);
		}
		else {
			String action = getCurrentAction(request);
			if(!StringHelper.isNullOrWhitespace(action) && action.equals("/logout"))
			{
				request.getSession().removeAttribute("TipoUsuarioLogueado");
				request.getSession().removeAttribute("UsuarioLogueado");
				request.getSession().removeAttribute("NombreUsuarioLogueado");
				doGet(request,response);
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewHomeIndex);
				dispatcher.forward(request, response);
			}
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
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewHomeIndex);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				addErrorAlertMessage(request,e.getMessage());
				doGet(request,response);
			}
		}
	}

}
