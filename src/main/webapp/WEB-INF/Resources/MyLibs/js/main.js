function RequestAjax(url, method, data, functPreLoader, functSuccess){
    $.ajax({  
        url: BASE_URL + url,  
        method: method,  
        data: data,
        datatype: "json",
        contentType:false,
        processData:false,
        beforeSend: function(){
            functPreLoader();
        },
        success:function(result){  
            functSuccess(result);
        }  
    });
}
function RequestAjaxJson(url, method, data, functPreLoader, functSuccess){
    $.ajax({  
        url: BASE_URL + url,  
        method: method,  
        data: data,
        datatype: "json",
        contentType: "application/json",
        processData:false,
        beforeSend: function(){
            functPreLoader();
        },
        success:function(result){  
            functSuccess(result);
        }  
    });
}

function RequestAjaxClear(url, method, data, functPreLoader, functSuccess){
    $.ajax({  
        url: "http://localhost/documentos/tool/" + url,  
        method: method,  
        data: data,
        datatype: "json",
        contentType: "application/json",
        processData:false,
        beforeSend: function(){
            functPreLoader();
        },
        success:function(result){  
            functSuccess(result);
        }  
    });
    return false;
}
function Make_DataTable(table, link, data, col){
    var tabla = $(table).DataTable({
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-MX.json'
        },
        scrollX: true,
        fixedHeader: true,
        ajax: {
            url: BASE_URL + link,
            type: "POST",
            data: data
        },
        columns: col
    });
    return tabla;
}