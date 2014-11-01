/**
 * Created by David on 2014-10-30.
 */
$(document).ready(function(){
	
	updateTable();
	
	addEvent();
});

function addEvent(){
    $("#bouton-sauvegarde-deplacement").on("click", function(){
        sauvegarderNouveauDeplacement();
    })
}

function sauvegarderNouveauDeplacement(){
    var data = getFormData();
    
    var successFunction = function(data, textStatus, jqXHR){
    		hideCallBack();
    		alert("Enregistrement reussi"); 
    		updateTable();
    	};
    
    j_post("/deplacementFormDeplacement",data, undefined, successFunction, undefined);
}

function getFormData(){

    var now = new Date();

    return JSON.stringify({
        "distance" : parseFloat($("#distance-input").val()),
        "coutkm" :  parseFloat($("#cout-km-input").val()),
        "identifiant" : "test",
        "description" : "",
        "date" : now.yyyymmdd()
    });
}

function updateTable(){
	var dataFromServer = [];
	var tpl = '{{#deplacements}}' +
			  '<tr>' +
			  	'<td class="date">{{date}}</td>' +
			    '<td class="distance">{{distance}}</td>' +
			    '<td class="cout-km">{{coutKm}}</td>' +
			    '<td class="commentaires">{{commentaires}}</td>' +
			  '</tr>' +
			  '{{/deplacements}}';
	
	var username = "test";
	
	var successFunction = function(data, textStatus, jqXHR){
			dataFromServer = data
		};
	
	j_get("/" + username + "/deplacements", undefined, successFunction, undefined);
	
	var rendered = Mustache.render(tpl, dataFromServer);
	
	$("#table-depense-deplacement").append(rendered);
}


