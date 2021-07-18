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
	<jsp:param name="title" value="Mis Cuentas" />
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
									<th>Tipo de cuenta</th>
									<th>Saldo</th>
									<th>CBU</th>
									<th>Nro de cuenta</th>
									<th>Alias</th>
									<th>Fecha de alta</th>
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
									<td><%=c.getTipoCuenta().getNombre()%></td>
									<td><%=c.saldoString()%></td>
									<td><%=c.getCBU()%></td>
									<td><%=c.getNumeroDeCuenta()%></td>
									<td><%=c.getAlias()%></td>
									<td><%=DateHelper.localDateToFormatString(c.getFechaAlta())%></td>
									<td>
										<a  title="Cambiar Alias" data-toggle="tooltip" class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/Cuentas/CambiarAlias?id=<%=id%>"> 
											<i class="fas fa-edit"></i>
										</a>
										<a  title="Movimientos" data-toggle="tooltip" class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/Cuentas/Movimientos?id=<%=id%>"> 
											<i class="fas fa-info"> </i>
										</a>  
										<a title="Desactivar" data-toggle="tooltip" class="btn btn-danger btn-sm btnDesactivar" data-idCuenta= "<%=id%>" href="${pageContext.request.contextPath}/Cuentas/Desactivar?id=<%=id%>&clienteId=<%=cliente.getClienteId()%>"> 
											<i class="fas fa-thumbs-down"></i>
										</a>
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
        return confirm("Esta seguro que quiere desactivar la cuenta #"+$(this).attr("data-idCuenta") +"? Para volver a activarla tendra que comunicarse con el banco");
    });
</script>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
