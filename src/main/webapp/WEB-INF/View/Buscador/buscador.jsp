<%@include file="../../Resources/Layout/header.jsp"%>
<%@include file="../../Resources/Layout/navbar.jsp"%>

<section id="section-search">
	<h3 class="fw-bolder">BUSCAR CONTENIDO</h3>
	<form action="buscador" method="post">
		<input type="hidden" name="accion" value="buscar">
		<div class="row g-3 align-items-center mb-4">
			<div class="col-1">
    			<label for="nombre" class="col-form-label">Título:</label>
  			</div>
  			<div class="col-2">
    			<input type="text" id="nombre" name="nombre" class="form-control form-control-sm">
  			</div>
		</div>
		<h4 class="fw-bold">Filtros</h4>
		<span>Use los filtros para refinar sus resultados.</span>
		<div class="row g-3 align-items-center mb-2 mt-4">
			<div class="col-1">
    			<label for="descripcion" class="col-form-label fw-bold">Descripción:</label>
  			</div>
  			<div class="col-4">
    			<input type="text" id="descripcion" name="descripcion" class="form-control form-control-sm">
  			</div>
  			<div class="col-3">
  			</div>
  			<div class="col-1">
    			<label for="titulo" class="col-form-label search-black fw-bold">Año:</label>
  			</div>
  			<div class="col-1">
    			<input type="text" id="anio" name="anio" class="form-control form-control-sm">
  			</div>
		</div>
		<div class="row g-3 align-items-center mb-3 mt-2">
			<div class="col-1">
    			<label for="titulo" class="col-form-label fw-bold">Autor:</label>
  			</div>
  			<div class="col-3">
    			<input type="text" id="autor" name="autor" class="form-control form-control-sm">
  			</div>
  			<div class="col-4">
  			</div>
  			<div class="col-1">
    			<button type="submit" class="btn btn-primary">APLICAR</button>
  			</div>
		</div>
	</form>
</section>

<%@include file="../../Resources/Layout/footer.jsp"%>