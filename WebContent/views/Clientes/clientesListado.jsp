<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%! String rol = "../shared/nav"+"Banco"+".jsp"; %>
<t:masterBanco>
 	<jsp:attribute name="title">
    Listado de Clientes
    </jsp:attribute>
	 <jsp:attribute name="asideBar">
     	<jsp:include page="../shared/asideBar.jsp"></jsp:include>
    </jsp:attribute>
    
    <jsp:body>
     <jsp:include page="../shared/alert.jsp"></jsp:include>
      <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Clientes</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive">
                <table class="table table-bordered table-striped">
                  <thead class="table-dark ">
                    <tr>
                      <th>#</th>
                      <th>Nro de Documento</th>
                      <th>Apellido</th>
                      <th>Nombre</th>
                      <th>E-mail</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>37662123</td>
                      <td>Diogenes</td>
                      <td>Felipe</td>
                      <td>f.diogenes@mail.com</td>
                      <td>
                      <div>
                          <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-pencil-alt"> </i>
                          </a>
                           <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-key"> </i>
                          </a>
                          <a class="btn btn-danger btn-sm" href="#">
                              <i class="fas fa-trash"></i>
                          </a>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>38612123</td>
                      <td>Imadia</td>
                      <td>Lucas</td>
                      <td>lucas.imadia@mail.com</td>
                      <td>
                      <div>
                          <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-pencil-alt"> </i>
                          </a>
                           <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-key"> </i>
                          </a>
                          <a class="btn btn-danger btn-sm" href="#">
                              <i class="fas fa-trash"></i>
                          </a>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>3</td>
                      <td>38876123</td>
                      <td>Ros</td>
                      <td>Lucia</td>
                      <td>l.ros@mail.com</td>
                      <td>
                      <div>
                          <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-pencil-alt"> </i>
                          </a>
                           <a class="btn btn-info btn-sm" href="#">
                              <i class="fas fa-key"> </i>
                          </a>
                          <a class="btn btn-danger btn-sm" href="#">
                              <i class="fas fa-trash"></i>
                          </a>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                <ul class="pagination pagination-sm m-0 float-right">
                  <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
              </div>
                </div>
                </div>
                  </Section>
    </jsp:body>
</t:masterBanco>    