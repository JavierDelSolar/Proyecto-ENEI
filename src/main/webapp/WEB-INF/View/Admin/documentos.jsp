<%@page import="com.jadc1.ProyectoUTP.Model.CategoriaModel"%>
<%@page import="java.util.List"%>
<%@page import="com.jadc1.ProyectoUTP.Model.TipoDocumentoModel"%>
<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>
<%@include file="../../Resources/Layout/navtab.head.jsp"%>
<script src="<c:url value="/Resources/JS/Admin/documentos.js"/>"></script>


<div class="row section-head mb-4">
	<h1 class="text-center mt-4 mb-4">DOCUMENTOS</h1>
	<div class="col-1"></div>
	<div class="col">
		<form id="frm" action="<%=request.getContextPath()%>/libro/crearLibro" method="post" enctype="multipart/form-data">
			<div class="row mb-3">
				<div class="col-1">
					<label for="nombre" class="col-sm-2 col-form-label">Titulo</label>
				</div>
				<div class="col-8">
					<input type="text" class="form-control" id="nombre" name="nombre">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
				</div>
				<div class="col-8">
					<input type="text" class="form-control" id="descripcion" name="descripcion">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="autor" class="col-sm-2 col-form-label">Autor</label>
				</div>
				<div class="col-5">
					<input type="text" class="form-control" id="autor" name="autor">
				</div>
				<div class="col-1">
					<label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
				</div>
				<div class="col-5">
					<input type="date" class="form-control" id="fecha" name="fecha">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="tipo_documento" class="col-sm-2 col-form-label">Tipo</label>
				</div>
				<div class="col-5">
					<select class="form-select" id="tipo_documento" name="tipo_documento">
						<%
						List<TipoDocumentoModel> list1 = (List<TipoDocumentoModel>)request.getAttribute("TipoDocumento");
						for(TipoDocumentoModel tipo:list1){
						%>
						<option value="<%= tipo.getId()%>"><%= tipo.getDescripcion() %></option>
						<%	
						}
						%>
					</select>
				</div>
				<div class="col-1">
					<label for="categoria" class="col-sm-2 col-form-label">Categoría</label>
				</div>
				<div class="col-5">
					<select class="form-select" id="categoria" name="categoria">
						<%
						List<CategoriaModel> list2 = (List<CategoriaModel>)request.getAttribute("Categoria");
						for(CategoriaModel tipo:list2){
						%>
						<option value="<%= tipo.getId()%>"><%= tipo.getDescripcion() %></option>
						<%	
						}
						%>
					</select>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="pdf" class="col-sm-2 col-form-label">Documento</label>
				</div>
				<div class="col-8">
					<input type="file" class="form-control" id="pdf" name="pdf">
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-1">
					<label for="portada" class="col-sm-2 col-form-label">Portada</label>
				</div>
				<div class="col-8">
					<input type="file" class="form-control" id="portada" name="portada">
				</div>
			</div>
		</form>
		<div class="row mb-3">
			<div class="col d-grid">
				<button type="button" class="btn btn-primary" option="crear">Crear</button>
			</div>
			<div class="col d-grid">
				<button type="button" class="btn btn-success" option="guardar">Guardar</button>
			</div>
			<div class="col d-grid">
				<button type="button" class="btn btn-danger" option="eliminar">Eliminar</button>
			</div>
		</div>
	</div>
	<div class="col-1"></div>
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