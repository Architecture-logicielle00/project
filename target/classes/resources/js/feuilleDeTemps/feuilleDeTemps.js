/**
 * Created by David on 2014-09-20.
 */

var tableData = {};

$(document).ready(function(){
	
	getData();
});



function saveData(){
    var timeSheetJSON = parseDataIntoJSON();

    var username = $("#utilisateur-dropdown").text().replace(/\s/g, '');
    
    j_post("/" + username + "/feuilleDeTemps",
            timeSheetJSON,
            function(){showCallBack();},
            function(data, textStatus, jqXHR){hideCallBack();alert("Enregistrement reussi");},
            function (jqXHR, textStatus, errorThrown){hideCallBack();alert("Une erreur s'est produite. Veuillez réessayer");});
}

function parseDataIntoJSON()
{
	var temp = jQuery.extend(true, {}, tableData);
	
	delete temp['joursPeriode'];
	
	temp['commentaires'] = [];
	$.each(tableData['commentaires'], function(index, value){
		(temp['commentaires'])[index] = value['commentaire'];
	})
	
	
	$.each(temp['taches'], function(index1, value){
		
		
		$.each(temp['taches'][index1]['heures'], function(index2, value){
			temp['taches'][index1]['nbHeuresParJours'][index2] = temp['taches'][index1]['heures'][index2]['heure'];
		});
		
		delete temp['taches'][index1]['heures'];
	})
	
	return JSON.stringify(temp);
	
}

function getData(){
	
	var username = $("#utilisateur-dropdown").text().replace(/\s/g, '');
	
	j_get('/' + username + '/feuilleDeTemps', 
			undefined, 
			function(data){
				tableData = data;
				adaptDataForMustacheRendering();
				drawTable(tableData);
			    initializeEvents();
				},
			undefined
			);
}


function drawTable(data){
	
	var tableTpl = '<tr>' +
			'<th class="fixcol2">Taches</th>' +
			'{{#joursPeriode}}' +
				'<th id="{{jourPeriode}}">{{jourPeriode}}</th>' +
			'{{/joursPeriode}}' +
		'</tr>' +
		'{{#taches}}' +
		'<tr>' +
			'<td class="fixcol2">{{tache}}</td>' +
			'{{#heures}}' +
				'<td><input id="{{tache}}_{{date}}" class="time-input" type="text" value="{{heure}}" /></td>' +
			'{{/heures}}' +
		'</tr>' +	
		'{{/taches}}' +
		'<tr class=commentaires-wrapper>' +
		'<td class="fixcol2">Commentaires</td>' +
		'{{#commentaires}}' +
			'<td><i class="commentaire-btn fa fa-2x"></i>' +
			'<textarea id="commentaire_{{date}}" class="comment-area" rows="5" cols="20" style="display:none" value="{{commentaire}}">{{commentaire}}</textarea>' +
		'</td>' +
		'{{/commentaires}}' +
		'<tr>';
	
	
	var dateWrapperTpl = '<h1>Feuille de temps</h1>' +
		'<div class="date-periode-grp">' +
			'<div id="debut-periode" class="date-periode">' +
				'<label for="debut-periode-input">Debut de la période</label>' +
				'<input id="debut-periode-input" type="date" name="debut-periode" value="{{debutPeriode}}" readonly="true">' +
			'</div>' +
			'<div id="fin-periode" class="date-periode">' +
				'<label for="fin-periode-input">Fin de la période</label>' +
				'<input	id="fin-periode-input" type="date" name="fin-periode" value="{{finPeriode}}" readonly="true">' +
			'</div>' +
		'</div>';
	
			
	$("#header-time-sheet").html(Mustache.render(dateWrapperTpl, data));	
	$("#table-wrapper > table").html(Mustache.render(tableTpl, data));
	
	$(".comment-area").change();
	
	renderCommentaires();
			
	

}

function renderCommentaires(){
	$commentairesFontList = $("#table-wrapper").find(".commentaire-btn");
	
	$.each(tableData['commentaires'], function(index, value){
		if(value == "")
			$($commentairesFontList[index]).addClass("fa-comment-o");
		else
			$($commentairesFontList[index]).addClass("fa-comment");
	});
}

function updateComments($el){
	var settingInput = ($el[0].id).split("_");
	
	$.each(tableData['commentaires'], function(index, value){
		if(((tableData['commentaires'])[index])['date'] == settingInput[1])
			((tableData['commentaires'])[index])['commentaire'] = $el.val();
	});
}

function updateHours($el){
	var settingInput = ($el[0].id).split("_");
	
	$.each(tableData['taches'], function(index1, value){
		if(((tableData['taches'])[index1])['tache'] == settingInput[0])
		{
			$.each(((tableData['taches'])[index1])['heures'], function(index2, value){
				if(((tableData['taches'])[index1])['heures'][index2]['date'] ==  settingInput[1])
					((tableData['taches'])[index1])['heures'][index2]['heure'] = parseFloat($el.val());
			});
		}
	});
}
 

function initializeEvents(){

    var $timeInputs = $("#table-wrapper").find("tr[id!='total-time-row']").find("input"),
        $previousDayButton = $(".fa-chevron-left"),
        $nextDayButton =  $(".fa-chevron-right"),
        $saveButton = $("#save-button"),
        $commentBtns = $(".commentaire-btn");
    	$commentAreas= $(".comment-area");


    $timeInputs.blur(function(){
        checkAndParseInput($(this));
        updateHours($(this));
    });

    $previousDayButton.click(function () {
        var leftPos = $('#table-wrapper').scrollLeft();
        $("#table-wrapper").animate({
            scrollLeft: leftPos - 76
        });
    });

    $nextDayButton.click(function () {
        var leftPos = $('#table-wrapper').scrollLeft();
        $("#table-wrapper").animate({
            scrollLeft: leftPos + 76
        });
    });

    $saveButton.click(function(){
    	saveData();
    });
    
    $commentBtns.on('click', function(){
    	var $textarea = $(this).next();
    	if($textarea.is(":visible")) 
    		$textarea.hide();
    	else
    		$textarea.show(); 
    });
    
    $commentAreas.on('change', function(){
    	
    	
    	
    	$btn = $(this).prev('i');
    	
    	if($(this).val() == ""){
    		$btn.removeClass('fa-comment');
    		$btn.addClass('fa-comment-o');
    	}
    	else{
    		$btn.addClass('fa-comment');
    		$btn.removeClass('fa-comment-o');
    	}
    	
    	updateComments($(this));
    		
    });
    
    
}

// Utils functions

function checkAndParseInput($input){
    var taskTimeRegExp = /\d$/g;

    if( $input.val().length === 0 || !($input.val().match(taskTimeRegExp)) || !($input.val() >=0 && $input.val() <= 12)) {
        $input.val("");
        $input.removeClass("input-not-empty");
    }
    else{
        $input.val(deleteLeadingZeros($input.val()));
        $input.addClass("input-not-empty");

    }
}

function deleteLeadingZeros(value){
    var s_value = value.toString();
    s_value = s_value.replace(/^0+/, '');

    return parseInt(s_value);
}

function adaptDataForMustacheRendering(){
	if(tableData != {}){
		
		var temp = jQuery.extend(true, {}, tableData);
		
		//joursPeriode
		temp['joursPeriode'] = [{'jourPeriode' : tableData.debutPeriode}];
		
		var trotteur = tableData.debutPeriode;
		
		while(trotteur != tableData.finPeriode){
			trotteur = incr_date(trotteur);
			temp['joursPeriode'].push({'jourPeriode' : trotteur});
		}
		
		//commentaires
		temp['commentaires'] = [];
		for(var i = 0 ; i < tableData.commentaires.length ; i++ ){
			temp['commentaires'].push({
				'commentaire' : tableData.commentaires[i],
				'date' : ((temp['joursPeriode'])[i])['jourPeriode']
			});
		}
		
		//heures
		$.each(temp['taches'], function(index, value){
			var heures = [];
			
			$.each(temp['taches'][index]['nbHeuresParJours'], function(index, value){
				heures.push({
					'heure' : value,
					'date' : ((temp['joursPeriode'])[index])['jourPeriode']
				});
			});
			
			((temp['taches'])[index])['heures'] = heures;
		});
		
		
		tableData = temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}