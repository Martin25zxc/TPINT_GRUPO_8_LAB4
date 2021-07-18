<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<%
String title = request.getParameter("title");
String dataTable = request.getParameter("dataTable");
String selectAutocomplete = request.getParameter("selectAutocomplete");
%>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><%=title%></title>
  <!-- MD5 -->
  <script src="${pageContext.request.contextPath}/assets/MD5/js/md5.min.js"></script>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/plugins/fontawesome-free/css/all.min.css">
  
  <link rel="shortcut icon" type="image/svg+xml" href="${pageContext.request.contextPath}/assets/favicon.svg"/>
	
  
  <!-- jQuery -->
   <script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/jquery/jquery.min.js"></script>
   
    <!-- selectAutocomplete -->
  <%if(selectAutocomplete != null) {%>
   	 <jsp:include page="../shared/selectAutocomplete.jsp"></jsp:include>
   <%}%>
    
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/dist/css/adminlte.min.css">
  <!-- dataTable -->
  <%if(dataTable != null) {%>
   	 <jsp:include page="../shared/dataTable.jsp"></jsp:include>
   <%}%>

	

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
 	<jsp:include page="../shared/asideBar.jsp"></jsp:include>
  <!-- Content Wrapper. Contains page content -->

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>${title}</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Home">Home</a></li>
              <li class="breadcrumb-item active"><%=title%></li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
     <!-- Alert -->
	     <jsp:include page="../shared/alert.jsp"></jsp:include>
    <!-- Alert -->