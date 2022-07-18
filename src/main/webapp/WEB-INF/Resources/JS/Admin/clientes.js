var columna = [
    { title: "Usuario", data: "usuario", className: "dt-head-center", width: "20%"},
    { title: "Nombres", data: "nombres", className: "dt-head-center", width: "25%"},
    { title: "Apellidos", data: "apellidos", className: "dt-head-center", width: "25%"},
    { title: "Correo", data: "correo", className: "dt-head-center", width: "30%"},
    { title: "", data: "config", className: "dt-head-center", width: "30%"},
];
$(document).ready(function(){
	var tbl = Make_DataTable("#tbl", "user/ListarClientes", null, columna);
	
	$("#tbl").on("click","button.button-edit",function(){
        var data = {};
        data["usuario"] = $(this).attr("usuario");
        data = JSON.stringify(data);
        RequestAjaxJson("user/getCliente", "POST", data, function(){
        }, function(result){
            $("#usuario").val(result.usuario);
            $("#password").val(result.password);
            $("#nombres").val(result.nombres);
            $("#apellidos").val(result.apellidos);
            $("#correo").val(result.correo);
        });
    });
    
    $("button[option='crear']").click(function(){
		var data = {};
		data["usuario"] = $("#usuario").val();
		data["password"] = $("#password").val();
		data["nombres"] = $("#nombres").val();
		data["apellidos"] = $("#apellidos").val();
		data["correo"] = $("#correo").val();
		data = JSON.stringify(data);
		RequestAjaxJson("user/crearCliente", "POST", data, function(){
        }, function(result){
            tbl.ajax.reload();
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