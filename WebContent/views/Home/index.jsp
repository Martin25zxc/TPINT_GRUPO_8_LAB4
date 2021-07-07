<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.integrador.model.Usuario"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:masterBanco>
 	<jsp:attribute name="title">
    Inicio
    </jsp:attribute>
    
    <jsp:attribute name="asideBar">
     	<jsp:include page="../shared/asideBar.jsp"></jsp:include>
    </jsp:attribute>
	
    <jsp:body>
    <section class="content">
    <jsp:include page="../shared/alert.jsp"></jsp:include> 
     	<div class="jumbotron">
		  <h1 class="display-4">Bienvenido a Integrador!</h1>
		  <p class="lead">Integrador es un sistema bancario diseñado para garantizar una buena experiencia a todos sus usuarios.</p>
		  <hr class="my-4">
		  <p>En este sistema podra realizar todas sus actividades de forma comoda y segura.</p>
		</div>
     </section>
    </jsp:body>
</t:masterBanco>   