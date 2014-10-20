$(document).ready(function() {
	ajouterNouvelleLigne();
	initialiserEvenements();
})

function sauvegarder() {
	alert("test");
	// TODO
	
    var formJSON = parseFormIntoJSON();

    $.ajax({
        url : "/sauvegarderDepenseDeplacement",
        type: "POST",
        data : formJSON,
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
    
    $.ajax({
        url : "/deplacementFormDiverse",
        type: "POST",
        data : formJSON,
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

function parseFormIntoJSON(table){
	
$('table-depense-deplacement').find('tr:has("td")').each(
		
		var date = $("#debut-periode-input").val();
       	var distance =$("#fin-periode-input").val();
       	var coutkm = $("#utilisateur-dropdown").val();
       	var nbRepas = $("#debut-periode-input").val();
       	var coutRepas = $("#fin-periode-input").val();
       	var coucher = $("#debut-periode-input").val();
       	var divers = $("#utilisateur-dropdown").val();
       	var soustotal = $("#fin-periode-input").val();
       	var description = $("#utilisateur-dropdown").val();
       	var total = $("#utilisateur-dropdown").val();
		
// (function($){
// var getJsonFromTable = function()
// {
// var rows = [];
// $('#table-depense-deplacement tr').each(function(i, n){
// var $row = $(n);
// rows.push({
// id: $row.find('td:eq(0)').text(),
// name: $row.find('td:eq(1)'.text(),
// add: $row.find('td:eq(2) .input-row'.text(),
// edit: $row.find('td:eq(3) .input-row'.text(),
// authorize: $row.find('td:eq(4) .input-row').text(),
// view: $row.find('td:eq(5) .input-row').text(),
// });
// return JSON.stringify(rows);
		        
    
    return JSON.stringify({
    	"date" : date
    	"distance" : distance
    	"coutkm" : coutkm
    	"nbRepas" : nbRepas
    	"coutRepas" : coutRepas
    	"coucher" : coucher
    	"divers" : divers
    	"soustotal" : soustotal
    	"description" : description
    	"total" : total
    	    	 
    });
	
}

// function ajouterNouvelleLigne() {
// $("#table-depense-deplacement").append(rowTemplate);
// }

function supprimerLignesSelectionne() {
	$("#table-depense-deplacement").find('tr > td > input:checked').parent()
			.parent().remove();
	$(".sous-total").change();
}

function initialiserEvenements() {
// $("#ajouter-nouvelle-ligne").on("click", function() {
// ajouterNouvelleLigne();
// });
//
// $("#supprimer-nouvelle-ligne").on("click", function() {
// supprimerLignesSelectionne();
// });

	$("#sauvegarder-feuille").on("click", function() {
		sauvegarder();
	});

	$('body').on(
			"change",
			"row-input",
			function() {
				var sousTotalCalcul = document.getElementById("distance").val
						* document.getElementById("cout-km").val()
						+ document.getElementById("nb-repas").val()
						* document.getElementById("cout-repas").val()
						+ (document.getElementById("coucher").val() * 1)
						+ (document.getElementById("divers").val() * 1);
						document.getElementById("sous-total").val(sousTotalCalcul);
						document.getElementById("sous-total").change();
			});

}

var rowTemplate = '<tr> \
                         <td><input type="checkbox"/></td> \
                         <td><input class="date row-input" type="text"/></td> \
                         <td><input class="distance row-input" type="text"/></td> \
                         <td><input class="cout-km row-input" type="text"/></td> \
                         <td><input class="nb-repas row-input" type="text"/></td> \
                         <td><input class="cout-repas row-input" type="text"/></td> \
                         <td><input class="coucher row-input" type="text"/></td> \
                         <td><input class="divers row-input" type="text" /></td> \
                         <td><input class="sous-total" type="text" readonly="true"/></td> \
                     </tr>';
