<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyprimeraparte.jsp"%>

<h1>Alta Usuarios</h1>
<p>Apartado usuarios</p>

<form class="user" method="post" action="SvUsuarios">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusu" name="nombreusu" placeholder="Nombre Usuario">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia" placeholder="Contraseña">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol" placeholder="Rol">
        </div>
    </div>

    <div class="col-md-6">
        <button type="submit" class="btn btn-primary btn-user btn-block">
            Crear Usuario
        </button>
    </div>
</form>

<%@include file="components/bodyfinal.jsp"%>
