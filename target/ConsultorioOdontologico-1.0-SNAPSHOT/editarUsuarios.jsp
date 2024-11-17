<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<%
    Usuario usu = (Usuario)request.getSession().getAttribute("usuEditar");
%>

<h1>Editar Usuarios</h1>
<p>Apartado edicion usuarios</p>

<form class="user" method="post" action="SvEditUsuarios">
    <input type="hidden" id="id" name="id" value="<%=usu.getId_usuario()%>">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusu"
                   name="nombreusu" placeholder="Nombre Usuario" value="<%=usu.getNombreUsuario()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia"
                   name="contrasenia" placeholder="Contraseña" value="<%=usu.getContrasenia()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol"
                   name="rol" placeholder="Rol" value="<%=usu.getRol()%>">
        </div>
    </div>

    <div class="col-md-6">
        <button type="submit" class="btn btn-primary btn-user btn-block">
            Editar Usuario
        </button>
    </div>
</form>

<%@include file="components/bodyfinal.jsp"%>
