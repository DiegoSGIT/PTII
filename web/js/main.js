$(document).ready(function(){
	var globalUrl = "http://localhost:8080/AxTPWS-1/rest/";
	var userText = "";
	var passText = "";
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
	$.ajax({
		type: "POST",
		data: {
			user: userText,
			pass: passText
		},
		url: "http://localhost:8080/RFIDSystem/rest/Login/Empleado",
		success: function(response) {
			//var resp = jQuery.parseJSON(response);
			if (response.id == 1) {
				$("#alert-login").hide();
				$("#login-form").hide();
				$("." + response.id).show();
				$(".operator-welcome").show();
				$("#name-welcome").text("Bienvenido " + response.id);
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
