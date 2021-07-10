<%@page import="com.integrador.model.Usuario"%>
<% String tipo =(String)session.getAttribute("TipoUsuarioLogueado");%>
<% Usuario user =(Usuario)session.getAttribute("UsuarioLogueado");
   String nombreUsuario = user.getNombreUsuario();
%>
<% int id = user.getUsuarioId();%>
<%! String rol =""; %>
<%  rol = tipo != null? "../shared/nav"+tipo+".jsp": "../shared/navBlank.jsp"; %>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="${pageContext.request.contextPath}/Home" class="brand-link">
      <img src="${pageContext.request.contextPath}/assets/adminLTE/dist/img/piggy_bank_PNG42w.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Integrador</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="https://www.gravatar.com/avatar/<%=nombreUsuario.hashCode() %>?d=identicon" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="${pageContext.request.contextPath}/Usuarios/<%=id%>" class="d-block"><%=nombreUsuario%></a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
      		 <jsp:include page="<%=rol%>"></jsp:include> 
      		<li class="nav-item">
           	 <a href="${pageContext.request.contextPath}/Home/logout" class="nav-link" onclick="return confirm('Esta seguro que desea cerrar sesión?')">
              <i class="nav-icon fas fa-sign-out-alt"></i>
              <p>
                Cerrar sesión
              </p>
            </a>
          </li>
       	 </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
