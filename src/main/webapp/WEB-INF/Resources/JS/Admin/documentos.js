var columna = [
    { title: "ID", data: "id", className: "dt-center"},
    { title: "Nombre", data: "nombre", className: "dt-head-center"},
    { title: "Autor", data: "autor", className: "dt-head-center"},
    { title: "Fecha", data: "fecha", className: "dt-head-center"},
    { title: "Categoria", data: "categoria", className: "dt-head-center"},
    { title: "", data: "config", className: "dt-head-center"},
];
$(document).ready(function(){
	var tbl = Make_DataTable("#tbl", "libro/ListarLibrosAdmin", null, columna);
	
	$("#tbl").on("click","button.button-edit",function(){
        var data = {};
        data["id"] = $(this).attr("libro");
        data = JSON.stringify(data);
        RequestAjaxJson("libro/getLibro", "POST", data, function(){
        }, function(result){
            $("#libro").val(result.id);
            $("#nombre").val(result.nombre);
            $("#descripcion").val(result.descripcion);
            $("#autor").val(result.autor);
            $("#fecha").val(result.fecha);
            $("#tipo_documento").val(result.tipo_documento);
            $("#categoria").val(result.id_categoria);
        });
    });
    
    $("button[option='crear']").click(function(){
		var data = new FormData($("#frm")[0]);
		//$("#frm").submit();
		$.ajax({  
	        url: "http://localhost/Documentos/Tool/crudTool/crearLibro",  
	        //url: "/ProyectoUTP/libro/crearLibro",
	        method: "POST",  
	        data: data,
	        datatype: "json",
	        contentType: false,
	        processData:false,
	        beforeSend: function(){
	        },
	        success:function(result){
				tbl.ajax.reload();
	        }  
	    });
	});
	
	$("button[option='guardar']").click(function(){
		var data = {};
		data["id"] = $("#libro").val();
		data["nombre"] = $("#nombre").val();
		data["descripcion"] = $("#descripcion").val();
		data["autor"] = $("#autor").val();
		data["fecha"] = $("#fecha").val();
		data["categoria"] = $("#categoria").val();
		data["tipo_documento"] = $("#tipo_documento").val();
		data = JSON.stringify(data);
		RequestAjaxJson("libro/updateLibro", "POST", data, function(){
        }, function(result){
            tbl.ajax.reload();
        });
	});
	
	$("button[option='eliminar']").click(function(){
		var data = {};
		data["libro"] = $("#libro").val();
		data = JSON.stringify(data);
		RequestAjaxJson("libro/deleteLibro", "POST", data, function(){
        }, function(result){
            tbl.ajax.reload();
        });
	});
});