<%@page import="com.integrador.model.Cliente"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%Cliente cliente = (Cliente)request.getAttribute("cliente"); 
int userId = cliente.getUsuarioId();
String identificacion = "#"+Integer.toString(cliente.getClienteId()) + " " + cliente.getApellido() + ", " + cliente.getNombre();
%>
<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Cambio de password" />
</jsp:include>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Cambio de contrase�a al Cliente <%=identificacion%></h3>
					</div>
					<!-- /.card-header -->
					<!-- form start -->
					<form action="${pageContext.request.contextPath}/Clientes/Cambiarpass"
						method="post">
						<input type="hidden" name="hUsuarioId" id="hUsuarioId" value="<%=userId%>">
						<input type="hidden" name="hClienteId" id="hClienteId" value="<%=cliente.getClienteId()%>">
						<!-- .card-body -->
						<div class="card-body">
							<!-- row -->
							<div class="row">
								<div class="col-sm-12 col-md-6">
									<!-- Contrase�a -->
									<div class="form-group">
										<label for="txtContrasenia">Contrase�a *</label> <input
											type="password" class="form-control" id="txtContrasenia"
											name="txtContrasenia" placeholder="Contrase�a" required>
									</div>
								</div>
								<div class="col-sm-12 col-md-6">
									<!-- Repetir Contrase�a -->
									<div class="form-group">
										<label for="txtContraseniaRepetir">Repetir Contrase�a
											*</label> <input type="password" class="form-control"
											id="txtContraseniaRepetir" name="txtContraseniaRepetir"
											placeholder="Repetir Contrase�a" required>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#confirmationModal">Guardar</button>
						</div>

						<!-- Modal -->
						<jsp:include page="../shared/modalConfirmacion.jsp">
							<jsp:param name="confirmationModalText"
								value="Confirme el cambio de password" />
						</jsp:include>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
