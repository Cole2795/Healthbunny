// JQUERY
$(function() {
	
	// Switch to Register
	$('.needAccount, .backLogin').click(function() {
		$('#login, #register, #formContainer').toggleClass('switch');
	});
	
	// Open Forgot Password
	$('.forgotBtn, .backLoginF').click(function() {
		$('#forgot').toggleClass('forgot');
	});
	
	// Open Why Register
	$('.regBtn').click(function() {
		$('#whyReg').toggleClass('whyRegister');
	});
	
	
});