
<!-- DataTables -->

<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Listado de Cuentas" />
	<jsp:param name="dataTable" value="true" />
</jsp:include>

<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Prestamos</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body table-responsive">
						<table id="tableCuentas"
							class="table table-bordered table-striped dataTableClass">
							<thead class="table-dark ">
								<tr>
									<th>#</th>
									<th>Cliente</th>
									<th>Importe</th>
									<th>Plazo</th>
									<th>Monto por cuota</th>
									<th>Estado solicitud</th>
								</tr>
							</thead>
							<tbody>
							
							<!-- row-->
								<tr>
									<td>1</td>
									<td>Sanchez, Anibal</td>
									<td>$100.000</td>
									<td>10</td>
									<td>$10.000</td>
									<td class="text-warning">Pendiente</td>
								</tr>
							<!-- row-->
								<tr>
									<td>2</td>
									<td>Eudora, Lucia</td>
									<td>$200.000</td>
									<td>20</td>
									<td>$20.000</td>
									<td class="text-success">Aceptado</td>
								</tr>
							<!-- row-->
								<tr>
									<td>3</td>
									<td>Acosta, Miguel</td>
									<td>$3.000</td>
									<td>1</td>
									<td>$3.000</td>
									<td class="text-success">Aceptado</td>
								</tr>
							<!-- row-->
								<tr>
									<td>4</td>
									<td>Sanchez, Ricardo</td>
									<td>$100.000</td>
									<td>10</td>
									<td>$10.000</td>
									<td class="text-danger">Rechazado</td>
								</tr>
							<!-- row-->
								<tr>
									<td>5</td>
									<td>Martino, Monica</td>
									<td>$100.000</td>
									<td>1</td>
									<td>$10.000</td>
									<td class="text-warning">Pendiente</td>
								</tr>
							<!-- row-->
								<tr>
									<td>6</td>
									<td>Viase, Erica</td>
									<td>$100.000</td>
									<td>2</td>
									<td>$50.000</td>
									<td class="text-warning">Aceptado</td>
								</tr>
							<!-- row-->
								<tr>
									<td>7</td>
									<td>Trince, Santigo</td>
									<td>$30.000</td>
									<td>2</td>
									<td>$10.000</td>
									<td class="text-warning">Pendiente</td>
								</tr>
							<!-- row-->
								<tr>
									<td>8</td>
									<td>Mentuli, Paula</td>
									<td>$25.000</td>
									<td>5</td>
									<td>$5.000</td>
									<td class="text-warning">Pendiente</td>
								</tr>
							<!-- row-->
								<tr>
									<td>9</td>
									<td>Ledesma, Renzo</td>
									<td>$40.000</td>
									<td>4</td>
									<td>$10.000</td>
									<td class="text-warning">Pendiente</td>
								</tr>
							<!-- row-->
								<tr>
									<td>10</td>
									<td>Diaz, Arturo</td>
									<td>$400.000</td>
									<td>10</td>
									<td>$40.000</td>
									<td class="text-warning">Aceptado</td>
								</tr>
							<!-- row-->
								<tr>
									<td>11</td>
									<td>Diaz, Marisa</td>
									<td>$100.000</td>
									<td>10</td>
									<td>$10.000</td>
									<td class="text-warning">Aceptado</td>
								</tr>
							
							</tbody>
						</table>
					</div>
					<!-- /.card-body -->
					<div class="card-footer clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</Section>

<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
