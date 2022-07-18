<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>
<%@include file="../../Resources/Layout/navtab.head.jsp"%>
<script src="<c:url value="/Resources/JS/Admin/clientes.js"/>"></script>


<div class="row section-head mb-4">
	<h1 class="text-center mt-4 mb-4">CLIENTES</h1>
	<div class="col-2"></div>
	<div class="col">
		<form>
			<input type="hidden" name="tipo" value="USER">
			<div class="row mb-3">
				<div class="col-1">
					<label for="usuario" class="col-sm-2 col-form-label">Usuario</label>
				</div>
				<div class="col-5">
					<input type="text" class="form-control" id="usuario" name="usuario">
				</div>
				<div class="col-1">
					<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
				</div>
				<div class="col-5">
					<input type="password" class="form-control" id="password" name="password">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="nombres" class="col-sm-2 col-form-label">Nombres</label>
				</div>
				<div class="col-5">
					<input type="text" class="form-control" id="nombres" name="nombres">
				</div>
				<div class="col-1">
					<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
				</div>
				<div class="col-5">
					<input type="text" class="form-control" id="apellidos" name="apellidos">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="correo" class="col-sm-2 col-form-label">Correos</label>
				</div>
				<div class="col-5">
					<input type="email" class="form-control" id="correo" name="correo">
				</div>
				<div class="col-2 d-grid">
					<button type="button" class="btn btn-primary" option="crear">Crear</button>
				</div>
				<div class="col-2 d-grid">
					<button type="button" class="btn btn-success" option="guardar">Guardar</button>
				</div>
				<div class="col-2 d-grid">
					<button type="button" class="btn btn-danger" option="eliminar">Eliminar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="col-2"></div>
</div>
<div class="row mt-4">
	<div class="col-1"></div>
	<div class="col">
		<table id="tbl" class="display compact row-border nowrap" style="width:100%"></table>
	</div>
	<div class="col-1"></div>
</div>

<%@include file="../../Resources/Layout/navtab.foot.jsp"%>
<%@include file="../../Resources/Layout/footer.jsp"%>