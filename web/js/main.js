$(document).ready(function(){
	var globalUrl = "http://192.168.43.47:8080/RFIDSystem/rest/";
	var userText = "";
	var passText = "";
	var data;
	window.location.hash="no-back-button";
		window.location.hash="Again-No-back-button";
		window.onhashchange=function(){
		window.location.hash="no-back-button";
	}

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
		url: globalUrl + "Login/Empleado",
		success: function(response) {
			//var resp = jQuery.parseJSON(response);
			if (response.id > 0) {

				//$("#alert-login").hide();
				//$("#login-form").hide();
				//$("." + response.id).show();
				//$(".operator-welcome").show();
				if(response.gerente)
    				window.location.href = 'registerEmployee.html';
				else
    				window.location.href = 'registerVisitor.html';
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
