<nav class="navbar navbar-expand-lg navbar-light bg-own">
	<div class="container-fluid">
		
		<a class="navbar-brand" href="#">
			<img src="<%=request.getContextPath()%>/Resources/Images/logo-blanco.png" alt="" width="75.6" height="48">
		</a>
		<div class="d-flex">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<%=request.getContextPath()%>/admin" id="btn-home" class="btn btn-primary" role="button"><i class="fa-solid fa-gear"></i></a>
			</security:authorize>
			<a href="<%=request.getContextPath()%>/home" id="btn-home" class="btn btn-primary" role="button"><i class="fa-solid fa-house"></i></a>
			<a href="<%=request.getContextPath()%>/buscador" id="btn-search" class="btn btn-primary" role="button"><i class="fa-solid fa-magnifying-glass"></i></a>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST"><button id="btn-logout" type="submit" class="btn btn-danger" role="button" value="Logout"><i class="fa-solid fa-right-from-bracket"></i></button></form:form>
    	</div>
	</div>
</nav>