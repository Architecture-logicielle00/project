
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
			  	'<td class="nbRepas">{{nbRepas}}</td>' +
			    '<td class="coutRepas">{{coutRepas}}</td>' +
			    '<td class="divers">{{divers}}</td>' +
			    '<td class="coucher">{{coucher}}</td>' +
			    '<td class="description">{{description}}</td>' +
			  '</tr>';
	
	var headerTpl = '<tr>' +
					 '<th>Date</th>' +
					 '<th>Nombre de Repas</th>' +
					 '<th>Cout par repas($)</th>' +
					 '<th>Coût divers($/Km)</th>' +
					 '<th>Coucher($/Km)</th>' +
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


