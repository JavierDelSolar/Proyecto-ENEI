<%@page import="com.jadc1.ProyectoUTP.Model.LibroModel"%>
<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>
<script src="<c:url value="/Resources/JS/Buscador/buscador.js"/>"></script>
<% LibroModel libro = (LibroModel)request.getAttribute("libro"); %>
<div class="row mt-4">
	<div class="col-2"></div>
	<div class="col">
		<a href="<%=request.getContextPath()%>/buscador" class="btn btn-primary mb-4">Regresar</a>
		<br>
		<div class="row mt-4">
			<div class="col-3">
				<img src="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_imagen() %>" width='200px' height='300px'>
			</div>
			<div class="col">
				<div class="row">
					<dt class="col-sm-3">Titulo</dt>
					<dd class="col-sm-9"><%= libro.getNombre() %></dd>
					
					<dt class="col-sm-3">Autor</dt>
					<dd class="col-sm-9"><%= libro.getAutor() %></dd>
					
					<dt class="col-sm-3">Descripción</dt>
					<dd class="col-sm-9"><%= libro.getDescripcion() %></dd>
					
					<dt class="col-sm-3">Fecha Creación</dt>
					<dd class="col-sm-9"><%= libro.getFecha() %></dd>
					
					<dt class="col-sm-3">Categoría</dt>
					<dd class="col-sm-9"><%= libro.getCategoria() %></dd>
					
					<dt class="col-sm-3">Descargar</dt>
					<dd class="col-sm-9"><a href="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_pdf() %>">Click Aqui</a></dd>
				</div>
			</div>
		</div>
	</div>
	<div class="col-2"></div>
</div>

<%@include file="../../Resources/Layout/footer.jsp"%>