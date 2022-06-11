<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>
<h1 class="text-center mt-4 mb-4">PANEL DE CONTROL</h1>
<div class="row">
	<div class="col-2"></div>
	<div class="col">
		<div class="row">
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="<%=request.getContextPath()%>/Resources/Images/businessman.png" class="card-img-top" alt="...">
					<div class="card-body text-center">
				    	<h3>Administrador</h3>
				 	</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="<%=request.getContextPath()%>/Resources/Images/working.png" class="card-img-top" alt="...">
					<div class="card-body text-center">
				    	<h3>Clientes</h3>
				 	</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="<%=request.getContextPath()%>/Resources/Images/book.png" class="card-img-top" alt="...">
					<div class="card-body text-center">
				    	<h3>Libros</h3>
				 	</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-2"></div>
</div>

<%@include file="../../Resources/Layout/footer.jsp"%>