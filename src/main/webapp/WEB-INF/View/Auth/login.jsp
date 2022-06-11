<%@ include file="../../Resources/Layout/header.jsp" %>
<div class="row container-login">
	<div class="col-7 container-logo">
	</div>
	<div class="col-5 text-center container-form">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<!-- action="${pageContext.request.contextPath}/loginUser" -->
				<form:form action="${pageContext.request.contextPath}/loginUser" method="POST">
					<input type="hidden" name="accion" value="login">
					<div class="mb-5">
						<label for="username" class="form-label fw-bolder">USUARIO</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Usuario">
					</div>
					<div class="mb-5">
						<label for="password" class="form-label fw-bolder">CONTRASEÑA</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Contraseña">
					</div>
					<div class="d-grid gap-2 mb-3">
						<button type="submit" value="Login" class="btn btn-primary">INGRESAR</button>
					</div>
					<div class="mb-1 link-logup">
						<a href="<%=request.getContextPath()%>/auth/logup">Crear cuenta</a>
					</div>
					<c:if test="${param.error!=null}">
						<div class="alert alert-danger" role="alert">
						 	Usuario/Contraseña errado
						</div>
					</c:if>
					<c:if test="${param.logout!=null}">
						<div class="alert alert-warning" role="alert">
						 	Usted ha salido del sistema
						</div>
					</c:if>
				</form:form>
			</div>
			<div class="col-sm-3"></div>
			
		</div>
	</div>
</div>

<%@include file="../../Resources/Layout/footer.jsp"%>