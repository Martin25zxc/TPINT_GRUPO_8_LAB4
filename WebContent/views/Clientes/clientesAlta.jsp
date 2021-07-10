

 <jsp:include page="../shared/templatingTop.jsp">
 		<jsp:param name="title" value="Alta de Clientes" />
 </jsp:include>
 
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Datos del Cliente</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="${pageContext.request.contextPath}/Clientes/Alta" method="post">
               <!-- .card-body -->
                <div class="card-body">
                <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Apellido -->
                      <div class="form-group">
                   		 <label for="txtApellido">Apellido *</label>
                    	<input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Apellido" required autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Nombre -->
                      <div class="form-group">
                   		 <label for="txtNombre">Nombre *</label>
                    	<input type="text" class="form-control" name= "txtNombre" id="txtNombre" placeholder="Nombre" required autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Documento -->
                      <div class="form-group">
                   		 <label for="txtNroDocumento">Nro de Documento *</label>
                    	<input type="text" class="form-control" name= "txtNroDocumento"  id="txtNroDocumento" placeholder="N�mero de Documento" required autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- FechaNacimiento -->
                      <div class="form-group">
                  		<label>Fecha de Nacimiento *</label>
                   		<div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                    <input type="text" name= "txtFechaNacimiento"  id="txtFechaNacimiento" placeholder="Fecha de nacimiento" class="form-control datemask" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask required>
                  </div>
                   	</div>
                    </div>
                  </div>
                   <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Nacionalidad -->
                      <div class="form-group">
                   		 <label for="txtNacionalidad">Nacionalidad *</label>
                    	<select class="form-control"  name= "txtNacionalidad"  id="txtNacionalidad" required>
                    		<option value="">Seleccione</option>
                    	</select>
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Provincia -->
                      <div class="form-group">
                   		 <label for="txtProvincia">Provincia *</label>
                    	<input type="text" class="form-control" name= "txtProvincia" id="txtProvincia" placeholder="Provincia" required autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Localidad -->
                      <div class="form-group">
                   		 <label for="txtLocalidad">Localidad</label>
                    	<input type="text" class="form-control" name= "txtLocalidad"  id="txtLocalidad" placeholder="Localidad" autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Direccion -->
                      <div class="form-group">
                   		 <label for="txtDireccion">Direcci�n</label>
                    	<input type="text" class="form-control" name= "txtDireccion" id="txtDireccion" placeholder="Direcci�n" autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Telefono 1 -->
                      <div class="form-group">
                   		 <label for="txtTelefono1">Tel�fono 1 </label>
                    	<input type="text" class="form-control" name= "txtTelefono1" id="txtTelefono1" placeholder="Tel�fono 1" autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Telefono 2 -->
                      <div class="form-group">
                   		 <label for="txtTelefono2">Tel�fono 2</label>
                    	<input type="text" class="form-control" name= "txtTelefono2" id="txtTelefono2" placeholder="Tel�fono 2" autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                   <!-- Usuario -->
                    <hr/>
                     <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- E-mail -->
                      <div class="form-group">
                   		 <label for="txtEmail">E-mail *</label>
                    	<div class="input-group mb-3">
                  			<div class="input-group-prepend">
                   		 		<span class="input-group-text"><i class="fas fa-envelope"></i></span>
                 	 		</div>
                  			<input type="email" id="txtEmail" name= "txtEmail"  class="form-control" placeholder="Email" required autocomplete="off" >
              	  		</div>
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Nombre de Usuario -->
                      <div class="form-group">
                   		 <label for="txtNombreUsuario">Nombre de Usuario *</label>
                    	<input type="text" class="form-control" id="txtNombreUsuario" name= "txtNombreUsuario" placeholder="Nombre de Usuario" required autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
               
                  <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Contrase�a -->
                      <div class="form-group">
                   		 <label for="txtContrasenia">Contrase�a *</label>
                    	<input type="password" class="form-control" id="txtContrasenia" name= "txtContrasenia"  placeholder="Contrase�a" required>
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Repetir Contrase�a -->
                      <div class="form-group">
                   		 <label for="txtContraseniaRepetir">Repetir Contrase�a *</label>
                    	<input type="password"  class="form-control" id="txtContraseniaRepetir" name= "txtContraseniaRepetir"  placeholder="Repetir Contrase�a" required>
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
			 		<jsp:param name="confirmationModalText"  value="Confirme el alta de cliente" />
			 	</jsp:include>
              </form>
            </div>
      	</div>
      </div>
      </div>
     </section>
     <script>
     $(function () {
     $.getJSON( "${pageContext.request.contextPath}"+"/assets/nacionalidades/nacionalidades.json", function( data ) {
    	  $.each(data, function (i, item) {
  		    $('#txtNacionalidad').append($('<option>', { 
  		        value: item.name,
  		        text : item.name 
  		    }));
  		});
  	  });
     });
     
     $(function () {
    	  	$('.datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' });
     });
     
     $(function () {
 	  	$('#txtNroDocumento').inputmask("99999999", { 'placeholder': '00000000' });
     });
     </script>
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>  