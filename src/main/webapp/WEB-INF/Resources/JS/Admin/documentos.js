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
	        }  
	    });
	});
	
	
	
	$("button[option='guardar']").click(function(){
		var data = {};
		data["usuario"] = $("#usuario").val();
		data["password"] = $("#password").val();
		data["nombres"] = $("#nombres").val();
		data["apellidos"] = $("#apellidos").val();
		data["correo"] = $("#correo").val();
		data = JSON.stringify(data);
		RequestAjaxJson("user/updateCliente", "POST", data, function(){
        }, function(result){
            tbl.ajax.reload();
        });
	});
	
	$("button[option='eliminar']").click(function(){
		var data = {};
		data["usuario"] = $("#usuario").val();
		data = JSON.stringify(data);
		RequestAjaxJson("user/deleteCliente", "POST", data, function(){
        }, function(result){
            tbl.ajax.reload();
        });
	});
});