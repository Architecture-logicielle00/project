/**
 * Created by David on 2014-09-20.
 */

$(document).ready(function(){
    getTimeSheetData();

    initializeTimeSheet();

    initializeEvents();
});

initializeTimeSheet(){

}


function FeuilleDeTemps(_dateDebut, _dateFin, _projetCollection) {
    this.dateDebut = _dateDebut;
    this.dateFin = _dateFin;
    this.projetCollection = _projetCollection;

}

FeuilleDeTemps.prototype.miseAJourTempsTacheJournee(_jour, _noTache, _nbHeures)
{
    this.projetCollection[_noTache][_jour] = _nbHeures;
}


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
    var JSONTimeSheet =  $('table.time-sheet-table tr').map(function() {
            var project =  $(this).find('td').map(function() {
                if($(this).find('input').length != 0)
                    return parseInt($(this).find('input').val());
                else
                    return $(this).find('span').text();
            }).get(),

            noProject = project[0],
            noTache = project[1],
            heuretravaille = project.slice(2);

        return {
            "noProjet" : noProject,
            "noTache" : noTache,
            "heureTravaille" : heuretravaille
        };


        }).get();

    return JSONTimeSheet = ;
}

function initializeEvents(){

    var $timeInputs = $("#table-wrapper").find("tr[id!='total-time-row']").find("input"),
        $previousDayButton = $(".fa-chevron-left"),
        $nextDayButton =  $(".fa-chevron-right"),
        $saveButton = $("#save-button"),


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



//TODO : a supprimer pour le sprint
function addDailyColumn(){
    var $tableRows = $("table.table.time-sheet-table > tbody > tr");

    $tableRows.each(function(index, value){
       if(index == 0)
           $(value).append("<th>New</th>");
       else
           $(value).append("<td><input type=\"text\"/></td>");
    });


}