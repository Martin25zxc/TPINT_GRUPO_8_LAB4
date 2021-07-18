<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
<!-- Cuentas  -->
<li class="nav-item">
  <a
    href="${pageContext.request.contextPath}/Cuentas/MisCuentas"
    class="nav-link"
    data-nav="cuentas"
  >
    <i class="nav-icon fas fa-tachometer-alt"></i>
    <p>Mis Cuentas</p>
  </a>
</li>
<!-- Prestamos  -->
<li class="nav-item">
  <a href="#" class="nav-link" data-nav="prestamos">
    <i class="nav-icon fas fa-hand-holding-usd"></i>
    <p>
      Prestamos
      <i class="right fas fa-angle-left"></i>
    </p>
  </a>
  <ul class="nav nav-treeview">
    <li class="nav-item">
      <a href="*" class="nav-link" data-nav="prestamos/solicitar">
        <i class="far fa-circle nav-icon"></i>
        <p>Solicitar</p>
      </a>
    </li>
    <li class="nav-item">
      <a href="*" class="nav-link" data-nav="prestamos/pagar">
        <i class="far fa-circle nav-icon"></i>
        <p>Pagar</p>
      </a>
    </li>
  </ul>
</li>
<!-- Movimientos  -->
<li class="nav-item">
  <a href="#" class="nav-link" data-nav="movimientos">
    <i class="nav-icon fas fa-exchange-alt"></i>
    <p>
      Movimientos
      <i class="right fas fa-angle-left"></i>
    </p>
  </a>
  <ul class="nav nav-treeview">
    <li class="nav-item">
      <a
        href="${pageContext.request.contextPath}/movimientos/transferir"
        class="nav-link"
        data-nav="movimientos/transferir"
      >
        <i class="far fa-circle nav-icon"></i>
        <p>Transferir</p>
      </a>
    </li>
    <li class="nav-item">
      <a
        href="${pageContext.request.contextPath}/movimientos/depositar"
        class="nav-link"
        data-nav="movimientos/depositar"
      >
        <i class="far fa-circle nav-icon"></i>
        <p>Depositar</p>
      </a>
    </li>
    <li class="nav-item">
      <a
        href="${pageContext.request.contextPath}/movimientos/retirar"
        class="nav-link"
        data-nav="movimientos/retirar"
      >
        <i class="far fa-circle nav-icon"></i>
        <p>Retirar</p>
      </a>
    </li>
  </ul>
</li>
