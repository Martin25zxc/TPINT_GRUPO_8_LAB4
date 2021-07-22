<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Transferir" />
</jsp:include>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Depositar</h3>
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
											id="txtImporte" name="txtImporte"
											placeholder="Importe" required type="number" step=".01">
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
