/**
 * Created by David on 2014-09-20.
 */

$(document).ready(function(){
    initializeEvents();
});


function saveTimeSheet(){
    var timeSheetJSON = parseTimeSheetIntoJSON();

    $.ajax({
        url : "AJAX_POST_URL",
        type: "POST",
        data : timeSheetJSON,
        success: function(data, textStatus, jqXHR)
        {
            //data - response from server
        },
        error: function (jqXHR, textStatus, errorThrown)
        {

        }
    });
}

function parseTimeSheetIntoJSON(){
	var debutPeriode = $("#debut-periode-input").val();
	var finPeriode=$("fin-periode-input").val();
	var employee = "DASAU";//$();
	
	var heuresParTaches = new Array();
	
    $('table.time-sheet-table').find('tr:contains("td")').each(function(){
    	var tache = $(this).first().find('input').val();
    	var heuresParJour = new Array();
    	
    	$(this).find('.time-input').each(function(){
    		var nbHeures = $(this).val() != "" ? parseFloat($(this).val()) : 0.0;
    		heureParJour.push(nbHeures);
    	})
    	
    	heuresParTaches.push({
    		"key" : tache,
    		"value" : heureParJour
    	});
    });
    
    return {
    	"debutPeriode" : debutPeriode,
    	"finPeriode" : finPeriode,
    	"employe" : employe,
    	"taches" : heuresParTaches
    };
}

function initializeEvents(){

    var $timeInputs = $("#table-wrapper").find("tr[id!='total-time-row']").find("input"),
        $previousDayButton = $(".fa-chevron-left"),
        $nextDayButton =  $(".fa-chevron-right"),
        $saveButton = $("#save-button");


    $timeInputs.blur(function(){
        checkAndParseInput($(this));
        updateTotalRowSection();
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
        saveTimeSheet();
    });
}

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

function updateTotalRowSection(){
    var $totalRowSection = $("#table-wrapper").find("#total-time-row").find("input");

    $totalRowSection.each(function(index, value){
        var sum = 0;
        var $columnIndexInputs =  $("#table-wrapper").find("tr[id!='total-time-row']").find("td:nth-child(" + (index + 3) + ") input");
        $columnIndexInputs.each(function(index, value){
            var realValue = parseInt($(value).val().length === 0 ? 0 : $(value).val());
            sum += realValue;
        });

        $(value).val(sum);

    })
}