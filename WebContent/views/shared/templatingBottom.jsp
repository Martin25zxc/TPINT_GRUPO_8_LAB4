
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

<script type="text/javascript">
$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
})
$(document).ready(function () {
			let arr = window.location.pathname.toLowerCase().split("/");
			  console.log(arr)
            let path = arr[2] + '/' + arr[3];
            console.log(arr[2])
            $(".nav-link[data-nav='" + arr[2] + "']").addClass("active").parent().addClass("menu-open");
            $(".nav-link[data-nav='" + path + "']").addClass("active");
});
</script>
</body>
</html>
