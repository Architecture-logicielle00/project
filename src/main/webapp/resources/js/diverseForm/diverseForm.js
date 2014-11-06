
$(document).ready(function(){
	
	updateTable();
	
	addEvent();
});

function addEvent(){
    $("#bouton-sauvegarde-diverse").on("click", function(){
        sauvegarderNouveaudiverse();
    })
}

function sauvegarderNouveaudiverse(){
    var data = getFormData();
    
    var successFunction = function(data, textStatus, jqXHR){
    		hideCallBack();
    		alert("Enregistrement reussi"); 
    		updateTable();
    	};
    
    j_post("/diverseFormdiverse",data, undefined, successFunction, undefined);
}

function getFormData(){

    var now = new Date();

    return JSON.stringify({
        "nbRepas" : parseFloat($("#nbRepas-input").val()),
        "coutRepas" :  parseFloat($("#coutRepas-input").val()),
        "divers" :  parseFloat($("#divers-input").val()),
        "coucher" :  parseFloat($("#coucher-input").val()),
        "identifiant" : $("#utilisateur-dropdown").text().replace(/\s/g, ''),
        "description" : "",
        "date" : now.yyyymmdd(),
        "time" : now.hhmmss()
    });
}

function updateTable(){
	var dataFromServer = [];
	var bodyTpl = '<tr>' +
			  	'<td class="date">{{date}}</td>' +
			    '<td class="distance">{{distance}}</td>' +
			    '<td class="cout-km">{{coutKm}}</td>' +
			    '<td class="commentaires">{{commentaires}}</td>' +
			  '</tr>';
	
	var headerTpl = '<tr>' +
					 '<th>Date</th>' +
					 '<th>Distance(Km)</th>' +
					 '<th>Cout($/Km)</th>' +
					 '<th>Description</th>' +
					 '<th></th>' +
					 '</tr>';
	
	var username = $("#utilisateur-dropdown").text().replace(/\s/g, '');
	
	var successFunction = function(data, textStatus, jqXHR){
			dataFromServer = data;
			
			var rendered = headerTpl;
			
			$.each(dataFromServer, function(index, value){
				rendered += Mustache.render(bodyTpl, dataFromServer[index]);
			});
			
			$("#table-depense-diverse").html(rendered);
		};
	
	j_get("/" + username + "/diverse", undefined, successFunction, undefined);
	

}


