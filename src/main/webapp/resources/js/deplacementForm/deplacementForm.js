
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
        "coutKm" :  parseFloat($("#cout-km-input").val()),
        "identifiant" : $("#utilisateur-dropdown").text().replace(/\s/g, ''),
        "description" : $("#comment-area").val(),
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
			    '<td class="commentaires">{{description}}</td>' +
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
			
			$("#table-depense-deplacement").html(rendered);
		};
	
	j_get("/" + username + "/deplacements", undefined, successFunction, undefined);
	

}


