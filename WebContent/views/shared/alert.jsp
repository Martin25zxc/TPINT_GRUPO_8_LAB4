<%String error =(String)request.getAttribute("alertErrorMessage");%>
<%String warning =(String)request.getAttribute("alertWarningMessage");%>
<%String success =(String)request.getAttribute("alertSuccessMessage");%>
<%String info =(String)request.getAttribute("alertInforMessage");%>

<%if(error != null) {%>
<div class="alert alert-danger alert-dismissible sm-12">
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
<%=error%>
</div>
<%}%>

<%if(success != null) {%>
<div class="alert alert-success alert-dismissible sm-12">
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
<%=success%>
</div>
<%}%>

<%if(warning != null) {%>
<div class="alert alert-warning alert-dismissible sm-12">
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
<%=warning%>
</div>
<%}%>

<%if(info != null) {%>
<div class="alert alert-info alert-dismissible sm-12">
<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
<%=info%>
</div>
<%}%>