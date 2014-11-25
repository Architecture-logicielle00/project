/**
 * Created by David on 2014-11-23.
 */


$(document).ready(function(){
    var data = getData();
    dessinerApprobations(data);
    initializeAccordion();
    initializeEvents();
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

    $("button.btn-primary").on("click", function(){
    	$(this).parent().parent().fadeOut("slow", function() {
    	    $(this).prev().remove();
    	    $(this).remove();
    	    
    	    alert("Approbation accepté");
    	  });
    });
    
    $("button.btn-danger").on("click", function(){
    	$(this).parent().parent().fadeOut("slow", function() {
    	    $(this).prev().remove();
    	    $(this).remove();
    	    
    	    alert("Approbation refusée : une notification sera envoyé");
    	  });
    });

    $(".fa-comments-o").on("click", function(){
        alert("Not Yet Implemented");
    });
}