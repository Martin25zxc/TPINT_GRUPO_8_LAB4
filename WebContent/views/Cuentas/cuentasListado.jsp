<%@page import="com.integrador.model.Cuenta"%>
<%@page import="com.integrador.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%
	List<Cuenta> lista = new ArrayList<Cuenta>();
	if (request.getAttribute("list") != null) {
		
		lista = (List<Cuenta>)request.getAttribute("list");
	}
%>
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
						<h3 class="card-title">Cuentas</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body table-responsive">
						<table id="tableCuentas"
							class="table table-bordered table-striped dataTableClass">
							<thead class="table-dark ">
								<tr>
									<th>#</th>
									<th>Nro de cuenta</th>
									<th>CBU</th>
									<th>Alias</th>
									<th>Cliente</th>
									<th>Tipo de cuenta</th>
									<th>Estado</th>
									<th>Fecha de alta</th>
									<th>Saldo</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Cuenta c : lista) {
								%>
								<%
								int id = c.getCuentaId();
								Cliente cliente = c.getCliente();
								cliente = cliente == null?new Cliente(): cliente;
								%>
								<tr>
									<td><%=id%></td>
									<td><%=c.getNumeroDeCuenta()%></td>
									<td><%=c.getCBU()%></td>
									<td><%=c.getAlias()%></td>
									<td><%=cliente.toString()%></td>
									<td><%=c.getTipoCuenta().getNombre()%></td>
									<%if(c.isActive()){%>
										<td class="text-success">Activo</td>
									<%}else{%>
										<td class="text-danger">Desactivado</td>
									<%}%>
									<td><%=DateHelper.localDateToFormatString(c.getFechaAlta())%></td>
									<td><%=c.saldoString()%></td>
									<td>
										<div>
											<%if(c.isActive()){%>
											<a title="Desactivar" data-toggle="tooltip" class="btn btn-danger btn-sm btnDesactivar" data-idCuenta= "<%=id%>" href="${pageContext.request.contextPath}/Cuentas/Desactivar?id=<%=id%>"> <i
												class="fas fa-thumbs-down"></i>
											</a>
											<%}else{%>
											<a title="Activar" data-toggle="tooltip" class="btn btn-success btn-sm btnActivar" data-idCuenta= "<%=id%>" href="${pageContext.request.contextPath}/Cuentas/Activar?id=<%=id%>"> <i
												class="fas fa-thumbs-up"></i>
											</a>
											<%}%>
										</div>
									</td>
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
<script type="text/javascript">
    $('.btnDesactivar').on('click', function () {
    	console.log($(this).attr("data-idCuenta"));
    	$(this).tooltip('hide');
        return confirm("Esta seguro que quiere desactivar el cuenta #"+$(this).attr("data-idCuenta") +"?");
    });
    $('.btnActivar').on('click', function () {
    	$(this).tooltip('hide');
        return confirm("Esta seguro que quiere activar el cuenta #"+$(this).attr("data-idCuenta") +"?");
    });
</script>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
