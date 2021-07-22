
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
						<h3 class="card-title">Transferir</h3>
					</div>
					<!-- /.card-header -->
					<!-- form start -->
					<!-- <form action="${pageContext.request.contextPath}/Movimientos/Transferir" method="post"> -->
					<form action="*" method="post">
						<!-- .card-body -->
						<div class="card-body">
							<!-- row -->
							<div class="row">
								<div class="col-sm-12 col-md-6">
									<!-- Cuenta -->
									<div class="form-group">
										<label for="txtCuentaATransferir">Cuenta a transferir *</label> 
										<div class="input-group">
										  <input type="text" name="txtCuentaATransferir" id="txtCuentaATransferir" class="form-control" required />
										   <div class="input-group-append">
										    <select class="form-select form-control" required >
											  <option value="">Seleccione </option>
											  <option value="CBU">CBU</option>
											  <option value="Alias">Alias</option>
										  	</select>
										  </div>
										</div>
									</div>
								</div>
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
							<button type="submit" class="btn btn-primary">Siguiente</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
