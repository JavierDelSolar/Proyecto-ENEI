<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>
<%@include file="../../Resources/Layout/navtab.head.jsp"%>

<h1 class="text-center mt-4 mb-4">PANEL DE CONTROL</h1>
<div class="row">
	<div class="col-1"></div>
	<div class="col">
		<div class="row">
			<div class="col">
				<img src="<%=request.getContextPath()%>/Resources/Images/panel_clientes.png" class="card-img-top" alt="...">
			</div>
			<div class="col">
				<img src="<%=request.getContextPath()%>/Resources/Images/panel_documentos.png" class="card-img-top" alt="...">
			</div>
			<div class="col">
				<img src="<%=request.getContextPath()%>/Resources/Images/panel_trabajadores.png" class="card-img-top" alt="...">
			</div>
		</div>
	</div>
	<div class="col-1"></div>
</div>

<%@include file="../../Resources/Layout/navtab.foot.jsp"%>
<%@include file="../../Resources/Layout/footer.jsp"%>