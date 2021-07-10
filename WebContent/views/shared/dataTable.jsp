<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">

<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/jszip/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/adminLTE/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script>
$(document).ready( function () {
    $('.dataTableClass').DataTable({
    	"language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
        }
    });
} );
</script>            