function sauvegarderEmployee() {
					
					alert("Début de la sauvegarde");
					
					   var utilisateur = {
					    	"nom" : $("#name").val(),
							"prenom" : $("prenom").val(),
							"email" : $("email").val(),
							"nomUsager" : $("#username").val(),
							"pays" : $("#pays").val(),
							"province" : $("#province").val(),
							"ville" : $("ville").val(),
							"codePostal" : $("codepos").val(),
							"mdp" : $("#password").val(),
						
							"mois" : $("#BirthMonth").val(),
							"jour" : $("#BirthDay").val(),
							"annee" : $("#BirthYear").val(),
						
							"sexe" : $("gender").val(),
							"telephone" : $("phone").val()
					   }
					   
					   $.ajax({
					      type: "POST",
					      contentType : 'application/json; charset=utf-8',
					      dataType : 'json',
					      url: "/creeUtilisateur"
					      data: JSON.stringify(utilisateur), // Note it is
																// important
					      success :function(result) {
					    	  alert("Employee sauvegardé");
					     }
					  });