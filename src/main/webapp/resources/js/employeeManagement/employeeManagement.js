/**
 * Created by David on 2014-09-23.
 */
$(document).ready(function(){
   var employeeFormHandler;

   $("button#add-new-employee-btn").click(function(){
       employeeFormHandler = showNewEmployeeForm();
   })
});

function showNewEmployeeForm(){
    window.open("/CreeUtilisateur","nom_popup","menubar=no, status=no, scrollbars=no, menubar=no, width=560, height=660");
}