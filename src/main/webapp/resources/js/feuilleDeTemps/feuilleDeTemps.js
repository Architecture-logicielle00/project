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
	
	var tpl = 
		'<tr>' +
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
	'{{/taches}}'; 
			
	$("#table-wrapper > table").html(Mustache.render(tpl, data));
			
	

}

function updateModel($el){
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
        $saveButton = $("#save-button");


    $timeInputs.blur(function(){
        checkAndParseInput($(this));
        updateModel($(this));
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
		var temp = tableData;
		
		//joursPeriode
		temp['joursPeriode'] = [{'jourPeriode' : tableData.debutPeriode}];
		
		var trotteur = tableData.debutPeriode;
		
		while(trotteur != tableData.finPeriode){
			trotteur = incr_date(trotteur);
			temp['joursPeriode'].push({'jourPeriode' : trotteur});
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