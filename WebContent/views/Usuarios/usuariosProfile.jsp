<%@page import="com.integrador.model.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<% Usuario user =(Usuario)session.getAttribute("UsuarioLogueado");
	String userName = user.getNombreUsuario();
	String userEmail = user.getEmail();
	String title ="Perfil de usuario"; 
	Boolean muestroDatosCliente = user.getCliente() != null; 
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String fecha = user.getFechaAlta().format(formatter);
	String tipo = user.getTipoUsuarioId();
	String fechaNacimiento = "";
	if(muestroDatosCliente){
		fechaNacimiento = user.getCliente().getFechaNacimiento().format(formatter);
	}
%>

 	<jsp:include page="../shared/templatingTop.jsp">
 		<jsp:param name="title" value="<%=title%>" />
 	</jsp:include>
 	
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">

            <!-- Profile Image -->
            <div class="card card-primary ">
            <div class="card-header">
                <h3 class="card-title">Datos de Usuario</h3>
              </div>
              <div class="card-body box-profile">
                <div class="text-center">
                  <img class="profile-user-img img-fluid img-circle" 
                       src="https://www.gravatar.com/avatar/<%=userName.hashCode()%>?d=identicon"
                       alt="User profile picture">
                </div>

                <h3 class="profile-username text-center"><%=userName%></h3>

                <p class="text-muted text-center"><%=userEmail%></p>

                <ul class="list-group list-group-unbordered mb-3">
                  <li class="list-group-item">
                    <b>Descripción</b> <a class="float-right"><%=user.getDescripcion()%></a>
                  </li>
                  <li class="list-group-item">
                    <b>Tipo de Usuario</b> <a class="float-right"><%=tipo%></a>
                  </li>
                  <li class="list-group-item">
                    <b>Fecha de alta</b> <a class="float-right"><%=fecha%></a>
                  </li>
                </ul>

              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
		<%if(muestroDatosCliente) {%>
            <!-- About Me Box -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Datos de Cliente</h3>
              </div>
              <!-- /.card-header -->
              <!-- .card-body -->
                <div class="card-body">
                <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Apellido -->
                      <div class="form-group">
                   		 <label for="txtApellido">Apellido</label>
                    	<input value="<%=user.getCliente().getApellido()%>" readonly type="text" class="form-control" name="txtApellido" id="txtApellido"   autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Nombre -->
                      <div class="form-group">
                   		 <label for="txtNombre">Nombre</label>
                    	<input value="<%=user.getCliente().getNombre()%>"  readonly type="text" class="form-control" name= "txtNombre" id="txtNombre" autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Documento -->
                      <div class="form-group">
                   		 <label for="txtNroDocumento">Nro de Documento</label>
                    	<input value="<%=user.getCliente().getNroDocumento()%>"  readonly type="text" class="form-control" name= "txtNroDocumento"  id="txtNroDocumento"  autocomplete="off" >
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
                    <input type="text" readonly value="<%=fechaNacimiento%>" name= "txtFechaNacimiento"  id="txtFechaNacimiento" class="form-control datemask" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask >
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
                   		 <input value="<%=user.getCliente().getNacionalidad()%>" readonly type="text" class="form-control" name= "txtNacionalidad" id="txtNacionalidad"  autocomplete="off" >
                    	
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Provincia -->
                      <div class="form-group">
                   		 <label for="txtProvincia">Provincia</label>
                    	<input value="<%=user.getCliente().getProvincia() %>" readonly type="text" class="form-control" name= "txtProvincia" id="txtProvincia" autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Localidad -->
                      <div class="form-group">
                   		 <label for="txtLocalidad">Localidad</label>
                    	<input value="<%=user.getCliente().getLocalidad()%>" readonly type="text" class="form-control" name= "txtLocalidad"  id="txtLocalidad" autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Direccion -->
                      <div class="form-group">
                   		 <label for="txtProvincia">Dirección</label>
                    	<input value="<%=user.getCliente().getDireccion()%>" readonly type="text" class="form-control" name= "txtDireccion" id="txtDireccion" autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
                  
                   <!-- row -->
                   <div class="row">
                    <div class="col-sm-12 col-md-6">
                      <!-- Telefono 1 -->
                      <div class="form-group">
                   		 <label for="txtTelefono1">Teléfono 1 </label>
                    	<input value="<%=user.getCliente().getTelefono1()%>" readonly type="text" class="form-control" name= "txtTelefono1" id="txtTelefono1" autocomplete="off" >
                  	  </div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                       <!-- Telefono 2 -->
                      <div class="form-group">
                   		 <label for="txtTelefono2">Teléfono 2</label>
                    	<input value="<%=user.getCliente().getTelefono2()%>" readonly type="text" class="form-control" name= "txtTelefono2" id="txtTelefono2"  autocomplete="off" >
                  	  </div>
                    </div>
                  </div>
               
                 </div>
                <!-- /.card-body -->
              <!-- /.card-body -->
            </div>
            <%}%>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    
<jsp:include page="../shared/templatingBottom.jsp"></jsp:include>