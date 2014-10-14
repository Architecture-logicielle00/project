$(document).ready(function() {
	ajouterNouvelleLigne();
	initialiserEvenements();
})

function sauvegarder() {
	alert("test");
	//TODO
}

function ajouterNouvelleLigne() {
	$("#table-depense-deplacement").append(rowTemplate);
}

function supprimerLignesSelectionne() {
	$("#table-depense-deplacement").find('tr > td > input:checked').parent()
			.parent().remove();
	$(".sous-total").change();
}

function initialiserEvenements() {
	$("#ajouter-nouvelle-ligne").on("click", function() {
		ajouterNouvelleLigne();
	});

	$("#supprimer-nouvelle-ligne").on("click", function() {
		supprimerLignesSelectionne();
	});

	$("#sauvegarder-feuille").on("click", function() {
		sauvegarder();
	});

	$('body').on(
			"change",
			".row-input",
			function() {
				var $row = $(this).parent().parent();
				var $inputsRow = $row.find(".row-input");

				var sousTotalCalcul = $inputsRow.filter(".distance").val()
						* $inputsRow.filter(".cout-km").val()
						+ $inputsRow.filter(".nb-repas").val()
						* $inputsRow.filter(".cout-repas").val()
						+ ($inputsRow.filter(".coucher").val() * 1)
						+ ($inputsRow.filter(".divers").val() * 1);

				$row.find(".sous-total").val(sousTotalCalcul);
				$row.find(".sous-total").change();
			});

	$('body').on("change", ".sous-total", function() {
		var total = 0;
		$(".sous-total").each(function() {
			total += $(this).val() != "" ? parseFloat($(this).val()) : 0;
		})

		$("#total").val(total);

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
