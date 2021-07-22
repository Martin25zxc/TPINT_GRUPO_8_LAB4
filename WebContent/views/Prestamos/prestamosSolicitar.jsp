<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Pagar" />
</jsp:include>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Solicitar prestamo</h3>
					</div>
					<!-- /.card-header -->
					<!-- form start -->
					<!-- <form action="${pageContext.request.contextPath}/Movimientos/Depositar" method="post"> -->
					<form action="*" method="post">
						<!-- .card-body -->
						<div class="card-body">
							<!-- row -->
							<div class="row">
								<div class="col-sm-12 col-md-6">
									<!-- Importe -->
									<div class="form-group">
										<label for="txtImporte">Importe *</label> <input  class="form-control"
											id="txtImporte" name="txtImporte"  type="number" step=".01"
											placeholder="Importe del prestamo" required>
									</div>
								</div>
							
								<div class="col-sm-12 col-md-6">
									<!-- Cuotas -->
									<div class="form-group">
										<label for="txtCuotas">Cuotas *</label> 
										<input  class="form-control"
											id="txtCuotas" name="txtCuotas" type="number"
											placeholder="Cuotas" required>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						<div class="card-footer">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmationModal">Guardar</button>
						</div>

						<!-- Modal -->
						<jsp:include page="../shared/modalConfirmacion.jsp">
							<jsp:param name="confirmationModalText"
								value="Confirme que quiere realizar el deposito" />
						</jsp:include>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
