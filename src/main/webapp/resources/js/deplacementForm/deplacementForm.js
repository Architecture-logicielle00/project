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
    j_post("/deplacementFormDeplacement",
            data,
            function(){showCallBack();},
            function(data, textStatus, jqXHR){hideCallBack();alert("Enregistrement reussi"); updateTable();},
            function (jqXHR, textStatus, errorThrown){
            	hideCallBack();
            	alert("Une erreur s'est produite. Veuillez réessayer");
            	}
            );
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
/*    return JSON.stringify({
        "date" : "30-10-2014",
        "distance" : "10",
        "coutkm" : "10",
        "description" : "test",
        "identifiant" : "ALSAM"


    });*/
}

function updateTable(){
	//var data= j_get("");
}
