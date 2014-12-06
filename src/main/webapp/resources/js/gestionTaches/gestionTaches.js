$(document).ready(function(){
	getData();

});

function getData(){
	j_get('/departement/projets', undefined, function(data){
			Data = data;
			renderTemplates();
			initializeEvents();
	    }, undefined);
}

function sendData(){
    var successFunction = function(data, textStatus, jqXHR){
		hideCallBack();
		alert("Enregistrement reussi");
	};


	j_post('/departement/projection',JSON.stringify(Data), undefined, successFunction, undefined);
}



function renderTemplates(){
    var employeesListTplRendered = Mustache.render($("#employees-list-tpl").html(), Data);
    $("#employees-list").html(employeesListTplRendered);

    var projectsTasksTplRendered = Mustache.render($("#projects-tasks-tpl").html(), Data);
    $("#projects-list").html(projectsTasksTplRendered);
}

function initializeEvents(){
    $(".project-checkbox").on("change", function(){
    	updateUIOnChangeProjectCheckbox($(this));
    	updateModel();
    });

    $(".task-checkbox").on("change", function(){
    	updateUIOnChangeTaskCheckBox($(this));
    	updateModel();
    });
    
    $(".employee-button").on("click", function(){
    	$(".employee-button").attr("selected", false);
    	$(this).attr("selected", true);
    });

    $("#save-button").on("click", function(){
        sendData();
    });
}

function updateModel(){
	var nomUtilisateurCourant = $(".employee-button[selected=selected]").html();
	
	var tachesSelection = [];
	
	($(".task-checkbox:checked").next()).each(function(i, n){
		tachesSelection.push($(n).html());
	});
	
	$.each(Data.employesTachesViewModels, function(i, n){
		if(n.nomUtilisateur = nomUtilisateurCourant)
			n.taches = tachesSelection;
	});
}

function updateUIOnChangeProjectCheckbox($target){
    var isChecked = $target.is(':checked');
    $target.next().next(".task-list").find("input.task-checkbox").prop("checked", isChecked);
}

function updateUIOnChangeTaskCheckBox($target){
    var isChecked = $target.is(':checked');

    var otherTasksInTheSameProject = $target.parent().parent().find(".task-checkbox");

    var isAllSiblingTasksInTheSameState = true;

    $(otherTasksInTheSameProject).each(function(index, value){
        if($($(otherTasksInTheSameProject)[index]).is(':checked') != isChecked)
            isAllSiblingTasksInTheSameState = false;
    });

    var relatedProject = $target.parents(".project").children(".project-checkbox");
    if(isAllSiblingTasksInTheSameState)
    {
        var relatedProject = $target.parents(".project").children(".project-checkbox");
        $(relatedProject).prop("checked", isChecked);
    }
    else{
        $(relatedProject).prop("checked", false);
    }

    $target.next().next(".task-list").find("input.task-checkbox").prop("checked", isChecked);
}

var Data = {};