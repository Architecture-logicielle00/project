$(document).ready(function(){
	$("#comment-area").hide();
	
	var toggle = true
	
	$("#comment-toggle").on('click', function(){
		if(toggle)
			$("#comment-area").show();
		else
			$("#comment-area").hide();
		
		toggle = !toggle;
	});

	
});
