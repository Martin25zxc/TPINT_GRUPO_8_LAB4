<%@tag description="master page" pageEncoding="iso-8859-1"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="asideBar" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><jsp:invoke fragment="title"/></title>
  <!-- MD5 -->
  <script src="${pageContext.request.contextPath}/assets/MD5/js/md5.min.js"></script>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/dist/css/adminlte.min.css">
  <!-- jQuery -->
	<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/jquery/jquery.min.js"></script>
  <script>
  	var hash = md5("email");
  </script>
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/Home" class="nav-link">Home</a>
      </li>
    </ul>

    <!-- Right navbar links -->

  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
 	 <jsp:invoke fragment="asideBar"/>
  <!-- Content Wrapper. Contains page content -->

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1><jsp:invoke fragment="title"/></h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Home">Home</a></li>
              <li class="breadcrumb-item active"><jsp:invoke fragment="title"/></li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- Main content -->
   	 <jsp:doBody />
    <!-- /.content -->
  </div>  
   
    
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 1.0.0
    </div>
    <strong>TP Integrador Laboratorio IV &copy; 2021 .</strong> Grupo VIII.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/assets/adminLTE/dist/js/adminlte.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/assets/adminLTE/dist/js/demo.js"></script>
</body>
</html>
