/**
 * Created by David on 2014-10-30.
 */

/**
 * Requetes POST
 * */
function j_post(_url, _data, _before, _success, _error){
    j_request("POST", _url, _data, _before, _success, _error);
}


/**
 * Requetes GET
 * */
function j_get(_url, _before, _success, _error){
    j_request("GET", _url, null, _before, _success, _error);
}


/**
 * Requetes PUT
 * */
function j_put(_url, _data, _before, _success, _error){
    j_request("PUT", _url, _data, _before, _success, _error);
}

function j_request(_type, _url, _data, _before, _success, _error){
    $.ajax({
        url : _url,
        type: _type,
        data : _data,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        before : _before || function(){},
        success: _success || function(data, textStatus, jqXHR){},
        error: _error || function (jqXHR, textStatus, errorThrown){}
    });
}