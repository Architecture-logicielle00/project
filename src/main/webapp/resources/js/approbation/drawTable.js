/**
 * Created by David on 2014-11-24.
 */


function dessinerApprobations(data){
    var approvalTpl = $("#approval-tpl").html();
    $("#approvals-list").html("");

    $.each(data, function(index, value){
        $("#approvals-list").append(Mustache.render(approvalTpl, value));
        var $cible = $("#approvals-list .demand-details").last();
        switch(value.type){
            case "feuilleDeTemps" :
                dessinerTableFeuilleDeTemps($cible, value.data);
                break;
            case "deplacements" :
                dessinerTableDeplacements($cible, value.data);
                break;
            case "depenses" :
                dessinerTableDepenses($cible, value.data);
                break;
        }
    });
}

function dessinerTableFeuilleDeTemps($el, data){

    var tableTpl = $("#feuille-de-temps-table-tpl").html();
    $el.html(Mustache.render(tableTpl, data));
}

function dessinerTableDeplacements($el, data){
    var tableTpl = $("#depenses-deplacements-table-tpl").html();

    $el.html(Mustache.render(tableTpl, data));
}

function dessinerTableDepenses($el, data){
    var tableTpl = $("#depenses-diverses-table-tpl").html();

    $el.html(Mustache.render(tableTpl, data));
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