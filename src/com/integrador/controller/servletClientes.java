package com.integrador.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.integrador.customExceptions.BusinessException;
import com.integrador.model.Cliente;
import com.integrador.model.Usuario;
import com.integrador.negocio.ClienteBll;
import com.integrador.negocio.UsuarioBll;
import com.integrador.negocioImpl.ClienteBllImpl;
import com.integrador.negocioImpl.UsuarioBllImpl;
import com.integrador.utilities.DateHelper;
import com.integrador.utilities.StringHelper;

/**
 * Servlet implementation class servletClientes
 */
@WebServlet("/Clientes/*")
public class servletClientes extends servletBaseIntegrador {

	private static final long serialVersionUID = -4717208001910999086L;

	private ClienteBll clienteBll;
	private UsuarioBll usuarioBll;
	private final String viewClienteAlta = "/views/Clientes/clientesAlta.jsp";
	private final String viewClienteListado = "/views/Clientes/clientesListado.jsp";
	private final String viewClienteModificar = "/views/Clientes/clientesModificar.jsp";
	private final String viewClienteCambioPass = "/views/Clientes/clientesCambioPass.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletClientes() {
		super();
		clienteBll = new ClienteBllImpl();
		usuarioBll = new UsuarioBllImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!this.isLogged(request)) {
			this.redirectToLogin(request, response);
		} else {
			String action = getCurrentAction(request);
			if (action != null) {
				switch (action) {
				case "/alta": {
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteAlta);
					dispatcher.forward(request, response);
					break;
				}
				case "/listado": {
					request.setAttribute("list", clienteBll.get());
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteListado);
					dispatcher.forward(request, response);
					break;
				}
				case "/get": {
					 Gson gson = new Gson();
					 List<Cliente> clientes = clienteBll.get();
					 String searchTerm = request.getParameter("search");
					
					 clientes = clientes.stream()
							.filter(x -> x.toString().toLowerCase().contains((searchTerm == null?"":searchTerm).toLowerCase()))
							.collect(Collectors.toList());
					 
					 clientes.sort(new Comparator<Cliente>() {
						    @Override
				            public int compare(Cliente o1, Cliente o2) {
				                return o1.getApellido().compareTo(o2.getApellido());
				            }
				        });
							
					 String employeeJsonString = gson.toJson(clientes);
					
					PrintWriter out = response.getWriter();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					out.print(employeeJsonString);
					out.flush();
					break;
				}
				case "/desactivar": {
					int id = Integer.parseInt(request.getParameter("id"));

					try {
						clienteBll.delete(id);
						this.addSuccessAlertMessage(request, "Se desactivo al cliente #" + id + " exitosamente.");
					} catch (Exception ex) {
						this.addErrorAlertMessage(request, "No se pudo desactivar el registro.");
					}
					request.setAttribute("list", clienteBll.get());
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteListado);
					dispatcher.forward(request, response);
					break;
				}
				case "/activar": {
					int id = Integer.parseInt(request.getParameter("id"));

					try {
						clienteBll.activate(id);
						this.addSuccessAlertMessage(request, "Se activo el cliente #" + id + " exitosamente.");
					} catch (Exception ex) {
						this.addErrorAlertMessage(request, "No se pudo eliminar el registro.");
					}
					request.setAttribute("list", clienteBll.get());
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteListado);
					dispatcher.forward(request, response);
					break;
				}
				case "/modificar": {
					int id = Integer.parseInt(request.getParameter("id"));
					Cliente cliente = this.clienteBll.get(id);
					request.setAttribute("cliente", cliente);
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteModificar);
					dispatcher.forward(request, response);
					break;
				}
				case "/cambiarpass": {
					int id = Integer.parseInt(request.getParameter("id"));
					Cliente cliente = this.clienteBll.get(id);
					request.setAttribute("cliente", cliente);
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteCambioPass);
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
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewClienteAlta);
					dispatcher.forward(request, response);
				}
				break;
			}
			case "/modificar": {
				try {
					
					this.modificar(request, response);
					this.addSuccessAlertMessage(request, "Se modificó correctamente el registro.");
					this.redirectToHome(request, response);

				} catch (Exception ex) {
					ex.printStackTrace();
					this.addErrorAlertMessage(request, ex.getMessage());
					String clienteId = request.getParameter("hClienteId");
					response.sendRedirect(request.getContextPath() + "/Clientes/modificar?id="+clienteId);
				}
				break;
			}
			case "/cambiarpass": {
				try {
					
					this.cambiarContrasenia(request, response);
					this.addSuccessAlertMessage(request, "Se modificó la contraseña correctamente.");
					this.redirectToHome(request, response);

				} catch (Exception ex) {
					ex.printStackTrace();
					this.addErrorAlertMessage(request, ex.getMessage());
					String clienteId = request.getParameter("hClienteId");
					response.sendRedirect(request.getContextPath() + "/Clientes/cambiarpass?id="+clienteId);
				}
				break;
			}
			}
		}
	}
    
	private void alta(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {
		String contrasenia = request.getParameter("txtContrasenia").trim();
		String contraseniaARepetir = request.getParameter("txtContraseniaRepetir").trim();
		if (StringHelper.isNullOrWhitespace(contrasenia)) {
			throw new IOException("Las constraseña es inválida.");
		}

		if (!contrasenia.equals(contraseniaARepetir)) {
			throw new IOException("Las constraseñas no coinciden.");
		}

		Cliente cliente = new Cliente();
		cliente.setNombre(request.getParameter("txtNombre").trim());
		cliente.setApellido(request.getParameter("txtApellido").trim());

		String fechaNacimientoSinFormat = request.getParameter("txtFechaNacimiento");

		LocalDate date = DateHelper.LocalDateFormat(fechaNacimientoSinFormat);
		cliente.setFechaNacimiento(date);

		String email = request.getParameter("txtEmail").trim();
		cliente.setEmail(email);
		cliente.setNacionalidad(request.getParameter("txtNacionalidad").trim());
		cliente.setProvincia(request.getParameter("txtProvincia").trim());
		cliente.setLocalidad(request.getParameter("txtLocalidad").trim());
		cliente.setDireccion(request.getParameter("txtDireccion").trim());
		cliente.setNroDocumento(request.getParameter("txtNroDocumento").trim());
		cliente.setTelefono1(request.getParameter("txtTelefono1").trim());
		cliente.setTelefono2(request.getParameter("txtTelefono2").trim());

		Usuario usuario = new Usuario();
		usuario.setContrasenia(contrasenia);
		usuario.setEmail(email);
		usuario.setNombreUsuario(request.getParameter("txtNombreUsuario").trim());
		cliente.setUsuario(usuario);

		this.clienteBll.post(cliente);
	}
	
	private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {
		
		Cliente cliente = new Cliente();
		cliente.setNombre(request.getParameter("txtNombre").trim());
		cliente.setApellido(request.getParameter("txtApellido").trim());

		String fechaNacimientoSinFormat = request.getParameter("txtFechaNacimiento");

		LocalDate date = DateHelper.LocalDateFormat(fechaNacimientoSinFormat);
		cliente.setFechaNacimiento(date);

		String email = request.getParameter("txtEmail").trim();
		cliente.setEmail(email);
		cliente.setNacionalidad(request.getParameter("txtNacionalidad").trim());
		cliente.setProvincia(request.getParameter("txtProvincia").trim());
		cliente.setLocalidad(request.getParameter("txtLocalidad").trim());
		cliente.setDireccion(request.getParameter("txtDireccion").trim());
		cliente.setNroDocumento(request.getParameter("txtNroDocumento").trim());
		cliente.setTelefono1(request.getParameter("txtTelefono1").trim());
		cliente.setTelefono2(request.getParameter("txtTelefono2").trim());
		
		int clienteId =Integer.parseInt(request.getParameter("hClienteId"));
		cliente.setClienteId(clienteId);
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		cliente.setUsuario(usuario);

		this.clienteBll.update(cliente);
	}
	private void cambiarContrasenia(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {
		String contrasenia = request.getParameter("txtContrasenia").trim();
		String contraseniaARepetir = request.getParameter("txtContraseniaRepetir").trim();
		if (StringHelper.isNullOrWhitespace(contrasenia)) {
			throw new IOException("Las constraseña es inválida.");
		}

		if (!contrasenia.equals(contraseniaARepetir)) {
			throw new IOException("Las constraseñas no coinciden.");
		}
		
		int usuarioId =Integer.parseInt(request.getParameter("hUsuarioId"));
		this.usuarioBll.cambioContrasenia(usuarioId, contrasenia);
	}
}
