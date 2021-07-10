<%@page import="com.integrador.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%
	List<Cliente> lista = new ArrayList<Cliente>();
	if (request.getAttribute("list") != null) {
		
		lista = (List<Cliente>)request.getAttribute("list");
	}
%>
<!-- DataTables -->

<jsp:include page="../shared/templatingTop.jsp">
	<jsp:param name="title" value="Listado de Clientes" />
	<jsp:param name="dataTable" value="true" />
</jsp:include>

<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Clientes</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body table-responsive">
						<table id="tableClientes"
							class="table table-bordered table-striped dataTableClass">
							<thead class="table-dark ">
								<tr>
									<th>#</th>
									<th>Nro de Documento</th>
									<th>Apellido</th>
									<th>Nombre</th>
									<th>E-mail</th>
									<th>Estado</th>
									<th>Fecha de alta</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Cliente c : lista) {
								%>
								<%
								int id = c.getClienteId();
								%>
								<tr>
									<td><%=id%></td>
									<td><%=c.getNroDocumento()%></td>
									<td><%=c.getApellido()%></td>
									<td><%=c.getNombre()%></td>
									<td><%=c.getEmail()%></td>
									<%if(c.isActive()){%>
										<td class="text-success">Activo</td>
									<%}else{%>
										<td class="text-danger">Desactivado</td>
									<%}%>
									<td><%=DateHelper.localDateToFormatString(c.getFechaAlta())%></td>
									<td>
										<div>
											<a  title="Modificar" data-toggle="tooltip" class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/Clientes/Modificar?id=<%=id%>"> <i
												class="fas fa-pencil-alt"> </i>
											</a> <a  title="Cambiar contraseña" data-toggle="tooltip" class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/Clientes/CambiarPass?id=<%=id%>"> <i
												class="fas fa-key"> </i>
											</a> 
											<%if(c.isActive()){%>
											<a title="Desactivar" data-toggle="tooltip" class="btn btn-danger btn-sm btnDesactivar" data-idCliente= "<%=id%>" href="${pageContext.request.contextPath}/Clientes/Desactivar?id=<%=id%>"> <i
												class="fas fa-thumbs-down"></i>
											</a>
											<%}else{%>
											<a title="Activar" data-toggle="tooltip" class="btn btn-success btn-sm btnActivar" data-idCliente= "<%=id%>" href="${pageContext.request.contextPath}/Clientes/Activar?id=<%=id%>"> <i
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
    	console.log($(this).attr("data-idCliente"));
    	$(this).tooltip('hide');
        return confirm("Esta seguro que quiere desactivar el cliente #"+$(this).attr("data-idCliente") +"?");
    });
    $('.btnActivar').on('click', function () {
    	$(this).tooltip('hide');
        return confirm("Esta seguro que quiere activar el cliente #"+$(this).attr("data-idCliente") +"?");
    });
</script>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>
