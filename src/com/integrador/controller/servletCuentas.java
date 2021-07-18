package com.integrador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.integrador.customExceptions.BusinessException;
import com.integrador.model.Cuenta;
import com.integrador.model.Usuario;
import com.integrador.negocio.CuentaBll;
import com.integrador.negocioImpl.CuentaBllImpl;

/**
 * Servlet implementation class servletCuentas
 */
@WebServlet("/Cuentas/*")
public class servletCuentas extends servletBaseIntegrador{
	
	private static final long serialVersionUID = 5504794695107506806L;
	
	private final String viewCuentaAlta = "/views/Cuentas/cuentasAlta.jsp";
	private final String viewCuentaListado = "/views/Cuentas/cuentasListado.jsp";
	private final String viewCuentaMis = "/views/Cuentas/cuentasMisCuentas.jsp";
	private final String viewCuentaCambioAlias = "/views/Cuentas/cuentasCambioAlias.jsp";
	//private final String viewCuentaMovimientos = "/views/Cuentas/cuentasMovimientos.jsp";
	
	private CuentaBll cuentaBll;
	
    public servletCuentas() {
        super();
        cuentaBll = new CuentaBllImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!this.isLogged(request)) {
			this.redirectToLogin(request, response);
		} else {
			String action = getCurrentAction(request);
			if (action != null) {
				switch (action) {
				case "/alta": {
					request.setAttribute("tiposCuentas", cuentaBll.getTiposCuentas());
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaAlta);
					dispatcher.forward(request, response);
					break;
				}
				case "/listado": {
					List<Cuenta> cuentas = cuentaBll.get("",0);
					request.setAttribute("list", cuentas);
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaListado);
					dispatcher.forward(request, response);
					break;
				}
				case "/desactivar": {
					int id = Integer.parseInt(request.getParameter("id"));
					String clienteIdParameter = request.getParameter("clienteId");
					try {
						cuentaBll.delete(id);
						this.addSuccessAlertMessage(request, "Se desactivo la cuenta #" + id + " exitosamente.");
					} catch (BusinessException ex) {
						this.addErrorAlertMessage(request, ex.getMessage());
					}
					catch (Exception ex) {
						this.addErrorAlertMessage(request, "No se pudo desactivar el registro.");
					}
					
					if(clienteIdParameter == null) {
						request.setAttribute("list", cuentaBll.get("",0));
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaListado);
						dispatcher.forward(request, response);
					}
					else {
						request.setAttribute("list", cuentaBll.get("T",Integer.parseInt(clienteIdParameter)));
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaMis);
						dispatcher.forward(request, response);
					}
					break;
				}
				case "/activar": {
					int id = Integer.parseInt(request.getParameter("id"));
					
					try {
						cuentaBll.activate(id);
						this.addSuccessAlertMessage(request, "Se activo la cuenta #" + id + " exitosamente.");
					} 
					catch (BusinessException ex) {
						this.addErrorAlertMessage(request, ex.getMessage());
					}
					catch (Exception ex) {
						this.addErrorAlertMessage(request, "No se pudo activar el registro.");
					}
					
					request.setAttribute("list", cuentaBll.get("",0));
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaListado);
					dispatcher.forward(request, response);
					break;
				}
				case "/miscuentas": {
					Usuario user = this.getUsuarioLogueado(request);
					if(user.getCliente() != null)
					{
						int id = user.getCliente().getClienteId();
						request.setAttribute("list", cuentaBll.get("T", id));
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaMis);
						dispatcher.forward(request, response);
					}
					else {
						this.addWarningAlertMessage(request, "El usuario logueado no posee atributos de cliente.");
						this.redirectToHome(request, response);
					}
					break;
				}
				case "/cambiaralias": {
					int id = Integer.parseInt(request.getParameter("id"));
					Cuenta cuenta = this.cuentaBll.get(id);
					request.setAttribute("cuenta", cuenta);
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewCuentaCambioAlias);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = getCurrentAction(request);
		if (action == null) {
			this.addWarningAlertMessage(request, "No se ha reconocido la accion que se deseaba realizar");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home/index.jsp");
			dispatcher.forward(request, response);
		} else {
			switch (action) {
			case "/alta": {
				try {
					this.alta(request, response);
					this.addSuccessAlertMessage(request, "Se agrego correctamente el registro.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home/index.jsp");
					dispatcher.forward(request, response);

				} catch (Exception ex) {
					ex.printStackTrace();
					this.addErrorAlertMessage(request, ex.getMessage());
					response.sendRedirect(request.getContextPath() + "/Cuentas/alta");
				}
				break;
			}
			case "/cambiaralias": {
				try {
					this.cambiarAlias(request, response);
					this.addSuccessAlertMessage(request, "Se modificó el alias correctamente.");
					this.redirectToHome(request, response);

				} catch (Exception ex) {
					ex.printStackTrace();
					this.addErrorAlertMessage(request, ex.getMessage());
					String cuentaId = request.getParameter("hCuentaId");
					response.sendRedirect(request.getContextPath() + "/Cuentas/cambiaralias?id="+cuentaId);
				}
				break;
			}
			}
		}
	}

	private void alta(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {

		Cuenta cuenta = new Cuenta();
		cuenta.setClienteId(Integer.parseInt((request.getParameter("slCliente"))));
		cuenta.setTipoCuentaId(Integer.parseInt((request.getParameter("slTipoCuenta"))));
	
		this.cuentaBll.post(cuenta);
	}
	
	private void cambiarAlias(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {
		int id = Integer.parseInt(request.getParameter("hCuentaId"));
		String alias = request.getParameter("txtAlias").trim();
		this.cuentaBll.updateAlias(id, alias);
	}
}
