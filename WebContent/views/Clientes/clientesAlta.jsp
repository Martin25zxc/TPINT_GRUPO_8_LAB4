<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:masterBanco>
 	<jsp:attribute name="title">
    Alta de Clientes
    </jsp:attribute>
    
     <jsp:attribute name="asideBar">
     	<jsp:include page="../shared/asideBar.jsp"></jsp:include>
    </jsp:attribute>
    
    <jsp:body>
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
          
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Datos del Cliente</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="${pageContext.request.contextPath}/Clientes/Alta" method="post">
                <div class="card-body">
                <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Apellido -->
                      <div class="form-group">
                   		 <label for="txtApellido">Apellido</label>
                    	<input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Apellido">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Nombre -->
                      <div class="form-group">
                   		 <label for="txtNombre">Nombre</label>
                    	<input type="text" class="form-control" name= "txtNombre" id="txtNombre" placeholder="Nombre">
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Documento -->
                      <div class="form-group">
                   		 <label for="txtNroDocumento">Nro de Documento</label>
                    	<input type="text" class="form-control" name= "txtNroDocumento"  id="txtNroDocumento" placeholder="Número de Documento">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- FechaNacimiento -->
                      <div class="form-group">
                  		<label>Fecha de Nacimiento</label>
                   		<div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                    <input type="text" name= "txtFechaNacimiento"  id="txtFechaNacimiento" placeholder="Fecha de nacimiento" class="form-control datemask" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask>
                  </div>
                   	</div>
                    </div>
                  </div>
                   <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Nacionalidad -->
                      <div class="form-group">
                   		 <label for="txtNacionalidad">Nacionalidad</label>
                    	<input type="text" class="form-control"  name= "txtNacionalidad"  id="txtNacionalidad" placeholder="Nacionalidad">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Provincia -->
                      <div class="form-group">
                   		 <label for="txtProvincia">Provincia</label>
                    	<input type="text" class="form-control" name= "txtProvincia" id="txtProvincia" placeholder="Provincia">
                  	  </div>
                    </div>
                  </div>
                  <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Localidad -->
                      <div class="form-group">
                   		 <label for="txtLocalidad">Localidad</label>
                    	<input type="text" class="form-control" name= "txtLocalidad"  id="txtLocalidad" placeholder="Localidad">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Direccion -->
                      <div class="form-group">
                   		 <label for="txtProvincia">Dirección</label>
                    	<input type="text" class="form-control" name= "txtDireccion" id="txtDireccion" placeholder="Dirección">
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Telefono 1 -->
                      <div class="form-group">
                   		 <label for="txtTelefono1">Teléfono 1 </label>
                    	<input type="text" class="form-control" name= "txtTelefono1" id="txtTelefono1" placeholder="Teléfono 1">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Telefono 2 -->
                      <div class="form-group">
                   		 <label for="txtTelefono2">Teléfono 2</label>
                    	<input type="text" class="form-control" name= "txtTelefono2" id="txtTelefono2" placeholder="Teléfono 2">
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
                   		 <label for="txtEmail">E-mail </label>
                    	<div class="input-group mb-3">
                  			<div class="input-group-prepend">
                   		 		<span class="input-group-text"><i class="fas fa-envelope"></i></span>
                 	 		</div>
                  			<input type="email" id="txtEmail" name= "txtEmail"  class="form-control" placeholder="Email">
              	  		</div>
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Nombre de Usuario -->
                      <div class="form-group">
                   		 <label for="txtNombreUsuario">Nombre de Usuario</label>
                    	<input type="text" class="form-control" id="txtNombreUsuario" name= "txtNombreUsuario" placeholder="Nombre de Usuario">
                  	  </div>
                    </div>
                  </div>
                   <!-- row -->
                  
                   <div class="row">
                    <div class="col-sm-12 col-md-12">
                      <!-- Descripcion  -->
                      <div class="form-group">
                   		 <label for="txtDescripcion">Descripción </label>
                    	<textarea id="txtDescripcion" name= "txtDescripcion"  class="form-control" rows="3" placeholder="Descripción"></textarea>
                  	  </div>
                    </div>
                  </div>
               
                  <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Contraseña -->
                      <div class="form-group">
                   		 <label for="txtContrasenia">Contraseña</label>
                    	<input type="password" class="form-control" id="txtContrasenia" name= "txtContrasenia"  placeholder="Contraseña">
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Repetir Contraseña -->
                      <div class="form-group">
                   		 <label for="txtContraseniaRepetir">Repetir Contraseña</label>
                    	<input type="password"  class="form-control" id="txtContraseniaRepetir" name= "txtContraseniaRepetir"  placeholder="Repetir Contraseña">
                  	  </div>
                    </div>
                  </div>
               
                   </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" name="btnAceptar" class="btn btn-primary" onclick="confirm('Confirme alta de usuario')" >Confirmar</button>
                </div>
              </form>
            </div>
      	</div>
      </div>
      </div>
     </section>
    </jsp:body>
</t:masterBanco>    