
$(document).ready(function() {
	    $('#signupForm').formValidation({
										    framework: 'bootstrap',
										    icon: {
										        valid: 'glyphicon glyphicon-ok',
										        invalid: 'glyphicon glyphicon-remove',
										        validating: 'glyphicon glyphicon-refresh'
										    },
										    fields: {
										        email: {
										        	verbose : false,
										            validators: {
										                notEmpty: {
										                    message: 'The email address is required and cannot be empty'
										                },
										                emailAddress: {
										                    message: 'The email address is not a valid'
										                },
										                remote: {
										                	message: 'This email address is not available',
										                    url: '/Accountmate/checkEmailAvailibility',
										                    type: 'GET',
										                    delay: 2000     // Send Ajax request every 2 seconds
										                }
										            }
										        },
										        password: {
										            validators: {
										                notEmpty: {
										                    message: 'The password is required and cannot be empty'
										                },
										                regexp:{
										                	regexp:"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[$@!%?&]).{7,12}$",
										                	message: 'The password should contain Minimum 7 and Maximum 12 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character'
										                }
										               }
										            } 
										        }
										    });
});

