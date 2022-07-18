var data = function(d){
	d.nombre = $("#nombre").val();
	d.descripcion = $("#descripcion").val();
	d.autor = $("#autor").val();
	d.anio = $("#anio").val();
};
var columna = [
    { title: "Portada", data: "nombre", className: "dt-center", width:"25%"},
    { title: "Descripcion", data: "config", className: "dt-center"},
];
$(document).ready(function(){
	var anio = (new Date).getFullYear();
	$("#anio").val(anio);
	
	var tbl = Make_DataTable("#tbl", "libro/ListarLibros", data, columna);
	
	$("#frm").submit(function(e){
		e.preventDefault();
		tbl.ajax.reload();
	})
});