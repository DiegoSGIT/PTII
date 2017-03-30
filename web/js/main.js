$(document).ready(function(){
	var globalUrl = "http://localhost:8080/AxTPWS-1/rest/";
	var userText = "";
	var passText = "";
	var data;
	//var logger = $.Logger();
	/*
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";
	window.onhashchange=function(){
		window.location.hash="no-back-button";
	}*/
	/*function fill-Groups() {
		var res = '<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">';
		res += '<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Group 1</a></li>';
		/*$.ajax({
			type: "POST",
			url: globalUrl + "availableGroups",
			success: function(response) {
				var resp = jQuery.parseJSON(response);
				$.each($.parseJSON(response), function (key, value) {
					res += '<li role="presentation"><a role="menuitem" tabindex="-1" href="#">' + value.groupName +'</a></li>';
				})
			},
			error: function (argument) {
				logger.info("Error");
			}
			//dataType: "text"
		});
		res += '<li role="presentation"><a role="menuitem" tabindex="-1" href="#">New group</a></li></ul>';
		logger.info(res);
		$("#available-groups").html(res);
	}*/

	$('#user').keypress(function (event) {
		if(event.keyCode  == 13) {
			$('#login-form').click();
		}
		
	});

	$('#pass').keypress(function (event) {
		if (event.keyCode == 13) {
			$('#login-form').click();
		}
	})



/*$('#login-form').click(function() {
    window.location.href = 'register.html';
    return false;
});*/

	$('#login-form').on('submit',function(e){
    e.preventDefault();
	userText = $('#user').val();
	passText = $('#pass').val();
	data = JSON.stringify(eval({
			"user": userText,
			"password": passText
		}));
	$.ajax({

      	contentType: "application/json",
      	dataType: "json",
		type: "POST",
		data: data,
		url: "http://localhost:8080/RFIDSystem/rest/Login/Empleado",
		success: function(response) {
			//var resp = jQuery.parseJSON(response);
			if (response.id > 0) {

				$("#alert-login").hide();
				$("#login-form").hide();
				$("." + response.id).show();
				$(".operator-welcome").show();
				if(response.gerente)
					$("#name-welcome").text("Bienvenido " + response.name + " gerente");
				else
					$("#name-welcome").text("Bienvenido " + response.name);
			}
			else {
				$("#alert-login").show();
				$("#user").text("");
				$("#pass").text("");
			}
		},
		error: function (argument) {
			$("#name-welcome").text("Error");
		}
		//dataType: "text"
	});

});

	$("#home-button").click(function () {
		// body...
	})
});
