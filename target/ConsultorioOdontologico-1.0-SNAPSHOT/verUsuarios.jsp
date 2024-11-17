<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Vista de usuarios</h1>
    <!--                    <p class="mb-4">Lista completa de usuarios</p>-->

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de usuario</th>
                            <th>Rol</th>
                            <th style="width:210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de usuario</th>
                            <th>Rol</th>
                            <th style="width:210px">Acción</th>
                        </tr>
                    </tfoot>

                    <%
                        List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
                    %>    

                    <tbody>
                        <% for (Usuario usu : listaUsuarios) { %>
                        <tr>
                            <td><%=usu.getId_usuario()%></td>
                            <td><%=usu.getNombreUsuario()%></td>
                            <td><%=usu.getRol()%></td>
                            <td style="display: flex; width:230px">
                                <form name="eliminar" action="SvElimUsuarios" method="POST">
                                    <input type="hidden" name="id" value="<%=usu.getId_usuario()%>"/>
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:#c0392b; border-color:rgb(227,230,240); margin-right:5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                </form>
                                <form name="editar" action="SvEditUsuarios" method="GET">
                                    <input type="hidden" name="id" value="<%=usu.getId_usuario()%>"/>
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:rgb(61, 99, 210); border-color:rgb(227,230,240); margin-left:5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

<%@include file="components/bodyfinal.jsp"%>
