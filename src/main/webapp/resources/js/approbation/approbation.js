/**
 * Created by David on 2014-11-23.
 */


$(document).ready(function(){
    var data = getData();
    dessinerApprobations(data);
    initializeAccordion();
    initializeEvents();
    checkApprovalNumber();
});

function initializeAccordion(){
    $("#approvals-list").accordion({});
}

function initializeEvents(){
    $(".fa-comments-o").hover(
        function(){
            $(this).removeClass("fa-comments-o").addClass("fa-comments");
        },
        function(){
            $(this).removeClass("fa-comments").addClass("fa-comments-o");
        }
    );

    $(".buttons-wrapper > button").on("click", function(){
    	if($(this).hasClass("btn-primary")){
			disapproval($(this));
			alert("Approbation accepté");
		}
		else if($(this).hasClass("btn-danger")){
			approval($(this));
			alert("Approbation refusée : une notification sera envoyé");
		} 
    	$(this).parent().parent().fadeOut("slow", function() {    		
    	    $(this).prev().remove();
    	    $(this).remove();
    	    checkApprovalNumber();
    	  });
    	
    	
    });


    $(".fa-comments-o").on("click", function(){
        alert("Not Yet Implemented");
    });
}

function checkApprovalNumber(){
	if(isNoApproval())
		showNoApprovalMessage();
}

function isNoApproval(){
	return $("#approvals-list").children().length == 0;
}

function showNoApprovalMessage(){
	$("#approvals-wrapper").append('<div class="alert alert-info" role="alert">Vous n\'avez aucune demande d\'approbation en cours</div>')
}