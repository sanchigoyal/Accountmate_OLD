
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
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: 'The password is required and cannot be empty'
                },
                stringLength: {
                    min: 7,
                    message: 'The password must have at least 7 characters'
                    }
                }
            } 
        }
    });
});