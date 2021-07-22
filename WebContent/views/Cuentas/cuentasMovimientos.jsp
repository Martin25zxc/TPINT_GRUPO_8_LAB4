<%@page import="com.integrador.model.ResultadoMovimiento"%>
<%@page import="com.integrador.utilities.StringHelper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%
	List<ResultadoMovimiento> lista = new ArrayList<ResultadoMovimiento>();
	if (request.getAttribute("list") != null) {
		
		lista = (List<ResultadoMovimiento>)request.getAttribute("list");
	}
%>
<!-- DataTables -->

<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Movimientos de cuenta" />
	<jsp:param name="dataTable" value="true" />
</jsp:include>

<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Movimientos</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body table-responsive">
						<table id="tableCuentas"
							class="table table-bordered table-striped dataTableClass">
							<thead class="table-dark ">
								<tr>
									<th>#</th>
									<th>Fecha de alta</th>
									<th>Detalle</th>
									<th>Importe</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (ResultadoMovimiento rm : lista) {
								%>
								<%
								int id = rm.getResultadoMovimientoId();
								%>
								<tr>
									<td><%=id%></td>
									<td><%=DateHelper.localDateToFormatString(rm.getMovimiento().getFechaAlta())%></td>
									<td><%=rm.getDetalle()%></td>
									<td><%=StringHelper.formatDecimal(rm.getImporte())%></td>
								</tr>
								<%
									}
								%>
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
