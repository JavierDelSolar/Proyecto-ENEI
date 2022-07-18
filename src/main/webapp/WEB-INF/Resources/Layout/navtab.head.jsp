<div id="panel" class="row">
	<div id="tab" class="col-2">
		<h4 class="text-center">ADMINISTRACIÓN DE LA BIBLIOTECA</h4>
		<ul id="navtab" class="nav flex-column">
			<li class="nav-item">
				<a class="nav-link active" href="<%=request.getContextPath()%>/admin/clientes"><i class="fa-solid fa-user"></i><span>Clientes</span></a>
			</li>
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav-item">
				<a class="nav-link active" href="<%=request.getContextPath()%>/admin/empleados"><i class="fa-solid fa-user-gear"></i><span>Empleados</span></a>
			</li>
			</security:authorize>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/admin/documentos"><i class="fa-solid fa-book"></i><span>Documentos</span></a>
				<!--<a class="nav-link" href="http://localhost/documentos/tool"><i class="fa-solid fa-book"></i><span>Documentos</span></a>-->
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/admin/graficos"><i class="fa-solid fa-chart-simple"></i><span>Gráficos</span></a>
			</li>
		</ul>
	</div>
	<div class="col">