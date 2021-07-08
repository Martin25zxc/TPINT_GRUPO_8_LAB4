  
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
               
          <!-- Clientes  -->
   		  <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Clientes
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
              <a href="${pageContext.request.contextPath}/Clientes/Alta" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta de clientes</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/Clientes/Listado" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Lista de clientes</p>
                </a>
              </li>
            </ul>
          </li>
         <!-- Cuentas  -->
         <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-book"></i>
              <p>
                Cuentas
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/Clientes/Alta" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta de cuentas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/Clientes/Listado" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Lista de cuentas</p>
                </a>
              </li>
            </ul>
          </li>
         <!-- Prestamos  -->
          <li class="nav-item">
            <a href="../widgets.html" class="nav-link">
              <i class="nav-icon fas fa-hand-holding-usd"></i>
              <p>
                Prestamos
              </p>
            </a>
          </li>
          <!-- Informes  -->
          <li class="nav-item">
            <a href="../widgets.html" class="nav-link">
              <i class="nav-icon fas fa-chart-bar"></i>
              <p>
                Informes
              </p>
            </a>
          </li>