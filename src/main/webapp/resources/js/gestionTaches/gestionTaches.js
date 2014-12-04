$(document).ready(function(){
    renderTemplates();

    initializeEvents();
});

function test(){
	j_get('/departement/projets', undefined, function(data){console.log(data);}, undefined);
}

function renderTemplates(){
    var employeesListTplRendered = Mustache.render($("#employees-list-tpl").html(), fakeData);
    $("#employees-list").html(employeesListTplRendered);

    var projectsTasksTplRendered = Mustache.render($("#projects-tasks-tpl").html(), fakeData);
    $("#projects-list").html(projectsTasksTplRendered);
}

function initializeEvents(){
    $(".project-checkbox").on("change", function(){
        var isChecked = $(this).is(':checked');
        $(this).next().next(".task-list").find("input.task-checkbox").prop("checked", isChecked);
    });

    $(".task-checkbox").on("change", function(){
        var isChecked = $(this).is(':checked');

        var otherTasksInTheSameProject = $(this).parent().parent().find(".task-checkbox");

        var isAllSiblingTasksInTheSameState = true;

        $(otherTasksInTheSameProject).each(function(index, value){
            if($($(otherTasksInTheSameProject)[index]).is(':checked') != isChecked)
                isAllSiblingTasksInTheSameState = false;
        });

        var relatedProject = $(this).parents(".project").children(".project-checkbox");
        if(isAllSiblingTasksInTheSameState)
        {
            var relatedProject = $(this).parents(".project").children(".project-checkbox");
            $(relatedProject).prop("checked", isChecked);
        }
        else{
            $(relatedProject).prop("checked", false);
        }

        $(this).next().next(".task-list").find("input.task-checkbox").prop("checked", isChecked);
    });

    $("#save-button").on("click", function(){
        alert("Not yet implemented");
    });
}

var fakeData = {
    employees :[
        {
            name : "Alexandra",
            projects : [
                       {
                           name : "Project 1",
                           tasks : [
                               {
                                   name : "task 1"
                               },
                           ]
                       },
            ]
        },
        {
            name : "David"
        },
        {
            name : "Jean-François"
        },
        {
            name : "Jean-Phillipe"
        },
        {
            name : "Lauriane"
        },
        {
            name : "Mounir"
        }
    ],
    projects :[
        {
            name : "Project 1",
            tasks : [
                {
                    name : "task 1"
                },
                {
                    name : "task 2"
                },
                {
                    name : "task 3"
                },
                {
                    name : "task 4"
                },
                {
                    name : "task 5"
                }
            ]
        },
        {
            name : "Project 2",
            tasks : [
                {
                    name : "task 1"
                },
                {
                    name : "task 2"
                },
                {
                    name : "task 3"
                },
                {
                    name : "task 4"
                },
                {
                    name : "task 5"
                }
            ]
        },
        {
            name : "Project 3",
            tasks : [
                {
                    name : "task 1"
                },
                {
                    name : "task 2"
                },
                {
                    name : "task 3"
                },
                {
                    name : "task 4"
                },
                {
                    name : "task 5"
                }
            ]
        },
        {
            name : "Project 4",
            tasks : [
                {
                    name : "task 1"
                },
                {
                    name : "task 2"
                },
                {
                    name : "task 3"
                },
                {
                    name : "task 4"
                },
                {
                    name : "task 5"
                }
            ]
        }
    ]
};