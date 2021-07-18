<%@page import="com.integrador.model.Cuenta"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%Cuenta cuenta = (Cuenta)request.getAttribute("cuenta"); 
int cuentaId = cuenta.getCuentaId();
String identificacion = "#"+Integer.toString(cuenta.getCuentaId()) + " " + cuenta.getCBU() + " - " + cuenta.getAlias();
%>
<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Cambio de alias" />
</jsp:include>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Cambio de alias de la cuenta <%=identificacion%></h3>
					</div>
					<!-- /.card-header -->
					<!-- form start -->
					<form action="${pageContext.request.contextPath}/Cuentas/CambiarAlias"
						method="post">
						<input type="hidden" name="hCuentaId" id="hCuentaId" value="<%=cuentaId%>">
						<!-- .card-body -->
						<div class="card-body">
							<!-- row -->
							<div class="row">
								<div class="col-sm-12 col-md-6">
				                      <!-- Alias -->
				                      <div class="form-group">
				                   		 <label for="txtAlias">Alias *</label>
				                    	<input type="text" class="form-control" name="txtAlias" id="txtAlias" placeholder="Nuevo Alias" required autocomplete="off" >
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
								value="Confirme el cambio de alias" />
						</jsp:include>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
