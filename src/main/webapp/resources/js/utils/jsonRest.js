/**
 * Created by David on 2014-10-30.
 */

function j_post(_url, _data){
    j_request("POST", _url, _data);
}

function j_get(_url){
    j_request("GET", _url, null);
}

function j_put(_url, _data){
    j_request("PUT", _url, _data);
}

function j_request(_type, _url, _data){
    $.ajax({
        url : _url,
        type: _type,
        data : _data,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function(data, textStatus, jqXHR)
        {
            // data - response from server
        },
        error: function (jqXHR, textStatus, errorThrown)
        {

        }
    });
}