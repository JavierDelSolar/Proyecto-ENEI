<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>

<h2>Generar Reporte</h2>
	
<form:form method="POST" action="${pageContext.request.contextPath}/reporte/generarReporte">
	<input type="text" name="prueba"/>
	<input type="submit"  value="Generate Employee List"  />
</form:form>


<%@include file="../../Resources/Layout/footer.jsp"%>