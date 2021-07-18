<%@page import="com.integrador.model.Cuenta"%>
<%@page import="com.integrador.model.Cliente"%>
<%@page import="com.integrador.model.TipoCuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.integrador.utilities.DateHelper"%>
<%
	List<TipoCuenta> tiposCuentas = new ArrayList<TipoCuenta>();
	if (request.getAttribute("tiposCuentas") != null) {
		
		tiposCuentas = (List<TipoCuenta>)request.getAttribute("tiposCuentas");
	}
%>
<%

%>
<jsp:include page="../shared/templatingTop.jsp">
 		<jsp:param name="title" value="Alta de Cuentas" />
 		<jsp:param name="selectAutocomplete" value="true" />
 </jsp:include>

    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Datos de la cuenta</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="${pageContext.request.contextPath}/Cuentas/Alta" method="post">
               <!-- .card-body -->
                <div class="card-body">
                <!-- row -->
                  <div class="row">
                  
                    <div class="col-sm-12 col-md-6">
                  	  <div class="form-group">
                   		<label for="txtNacionalidad">Cliente *</label>
                    	<select class="form-control select2" id="slCliente" name="slCliente" data-dropdown-css-class="select2-blue" style="width: 100%;" required>
						</select>
                  	  </div>
                    </div>
                    
                     <div class="col-sm-12 col-md-6">
                      <!-- Nacionalidad -->
                      <div class="form-group">
                   		 <label for="txtNacionalidad">Tipo de cuenta *</label>
                    	<select class="form-control"  name= "slTipoCuenta"  id="slTipoCuenta" required>
                    		<option value="">Seleccione</option>
                    		<%for(TipoCuenta tc : tiposCuentas){
                    			%>
                    			<option value="<%=tc.getTipoCuentaId()%>"><%=tc.getNombre()%></option>
                    		<%}
                    			
                    		%>
                    	</select>
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
			 		<jsp:param name="confirmationModalText"  value="Confirme el alta de cuenta" />
			 	</jsp:include>
              </form>
            </div>
      	</div>
      </div>
      </div>
     </section>
     <script>
      $('#slCliente').select2({
    	  placeholder: "Seleccione un cliente",
    	    allowClear: true,
		  ajax: {
		    url: '${pageContext.request.contextPath}/Clientes/get',
		    data: function (params) {
		      let query = {
		        search: params.term,
		        type: 'public'
		      }
		      return query;
		    },
		    delay: 500,
		    processResults: function (data) {
		    	let a = data.map(x =>({id : x.clienteId , text : `(#\${x.clienteId}) \${x.apellido}, \${x.nombre} (\${x.nroDocumento})`}));
		        return {
		          results:  a
		        };
		    }
		  }
		});
     </script>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>  