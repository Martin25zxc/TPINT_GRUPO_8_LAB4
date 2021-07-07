<%@page import="com.integrador.model.AlertMessage"%>
<%AlertMessage alert =(AlertMessage)request.getAttribute("alertMessage");%>

<%if(alert != null) {%>
<div class="alert alert-danger alert-dismissible sm-12">
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
<%=alert.getMessage()%>
</div>
<%}%>