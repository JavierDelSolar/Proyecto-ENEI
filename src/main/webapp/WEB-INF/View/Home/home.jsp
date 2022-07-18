<%@page import="com.jadc1.ProyectoUTP.Config.Constants"%>
<%@page import="java.util.List"%>
<%@page import="com.jadc1.ProyectoUTP.Model.LibroModel"%>
<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>

<section id="section-search" class="section-index">
	<h1>BIENVENIDOS A LA</h1>
	<h1>BIBLIOTECA DIGITAL DE</h1>
	<h1>INEI</h1>
</section>

<section id="libros">
	<h4>Libros Contables</h4>
	<br>
	<div class="row">
		<% 
			List<LibroModel> list1 = (List<LibroModel>)request.getAttribute("Lista1");
			int row = 0;
			for(LibroModel libro: list1){
				row++;
		%>
		<div class="col-sm-1 text-center">
			<a href="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_pdf() %>">
				<img src="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_imagen() %>" class="img-fluid rounded-start" width="60%" height="60%"><br>				
				<span class="fw-bold"><%= Constants.MESES[row-1] %>_2000</span>
			</a>
		</div>
		<% } %>
	</div>
	<hr>
	<h4>Libros Presupuestos</h4>
	<br>
	<div class="row">
		<% 
			List<LibroModel> list2 = (List<LibroModel>)request.getAttribute("Lista2");
			row = 0;
			for(LibroModel libro: list2){
				row++;
		%>
		<div class="col-sm-1 text-center">
			<a href="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_pdf() %>">
				<img src="<%= request.getContextPath()%>/Resources/Files/<%= libro.getRuta_imagen() %>" class="img-fluid rounded-start" width="60%" height="60%"><br>
				<span class="fw-bold"><%= Constants.MESES[row-1] %>_2000</span>
			</a>
		</div>
		<% } %>
	</div>
</section>


<%@include file="../../Resources/Layout/footer.jsp"%>