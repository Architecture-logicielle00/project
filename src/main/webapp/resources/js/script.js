/**
 * Created by David on 2014-09-20.
 */

$(document).ready(function(){

    $("#table-wrapper").find("tr[id!='total-time-row']").find("input").blur(function()
    {
        checkAndParseInput($(this));
        updateTotalRowSection();

    });

    $(".fa-chevron-left").click(function () {
        var leftPos = $('#table-wrapper').scrollLeft();
        $("#table-wrapper").animate({
            scrollLeft: leftPos - 76
        });
    });

    $(".fa-chevron-right").click(function () {
        var leftPos = $('#table-wrapper').scrollLeft();
        $("#table-wrapper").animate({
            scrollLeft: leftPos + 76
        });
    });
});

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

function addDailyColumn(){
    var $tableRows = $("table.table.time-sheet-table > tbody > tr");

    $tableRows.each(function(index, value){
       if(index == 0)
           $(value).append("<th>New</th>");
       else
           $(value).append("<td><input type=\"text\"/></td>");
    });


}