function envoyer(path, data) {
	var jData = JSON.stringify(data);
	$.ajax({
        url : path,
        type: "POST",
        data : jData,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function(reponse)
        {
        	if(reponse.statut){
        		document.location.href = reponse.url;
        	}
        	else{
        		alert(reponse.message)
        	}
        	
        },
        error: function ()
        {
            alert("Erreur!");
        }
    });
}

function creerEmploye(){
	var employe = {
			   "nomUtilisateur" : $("#username").val(),
			   "nom" : $("#name").val(),
			   "prenom" : $("#prenom").val(),
			   "email": $("#email").val(),
			   "pays" : $("#pays").val(),
			   "province" : $("#province").val(),
			   "ville" : $("#ville").val(),
			   "codePostal" : $("#codepos").val(),
			   "sexe" : $("#gender").val(),
			   "telephone" : $("#phone").val(),
			   "statutGestionnaire" : $("#gestionnaire").is(":checked")
		}
	
	envoyer("/creationEmployee", employe);
}

$(document).ready(function(){
	var $button = $("#envoyer");
	$button.click(function(){
		creerEmploye();
    });
});

