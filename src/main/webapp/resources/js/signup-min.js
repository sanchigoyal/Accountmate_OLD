    $(function(argument) {
      $('.on-off').bootstrapSwitch();
    });
    
	$(document).ready(function() {
	    // You don't need to care about this function
	    // It is for the specific demo
	    /*function adjustIframeHeight() {
	        var $body   = $('body'),
	                $iframe = $body.data('iframe.fv');
	        if ($iframe) {
	            // Adjust the height of iframe
	            $iframe.height($body.height());
	        }
	    }*/
	
	    $('#registrationForm')
	        .formValidation({
	            framework: 'bootstrap',
	            icon: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
	            // This option will not ignore invisible fields which belong to inactive panels
	            excluded: ':disabled',
	            fields: {
	            	firstName: {
		                message: 'The firstname is not valid',
		                validators: {
		                    notEmpty: {
		                        message: 'The firstname is required and cannot be empty'
		                    },
		                    stringLength: {
		                        min: 3,
		                        max: 30,
		                        message: 'The firstname must be more than 3 and less than 30 characters long'
		                    },
		                    regexp: {
		                        regexp: /^[a-zA-Z]+$/,
		                        message: 'The firstname can only consist of alphabets'
		                    }
		                }
		            },
		            lastName: {
		                message: 'The lastname is not valid',
		                validators: {
		                    notEmpty: {
		                        message: 'The lastname is required and cannot be empty'
		                    },
		                    stringLength: {
		                        min: 3,
		                        max: 30,
		                        message: 'The lastname must be more than 3 and less than 30 characters long'
		                    },
		                    regexp: {
		                        regexp: /^[a-zA-Z]+$/,
		                        message: 'The lastname can only consist of alphabets'
		                    }
		                }
		            },
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
		            },
		            repassword: {
		                validators: {
		                    notEmpty: {
		                        message: 'Re-enter your password'
		                    },
		                    identical: {
		                        field: 'password',
		                        message: 'The password is not matching'
		                    }
		                }
		            },
		            'company.companyName': {
		                message: 'The Company/Business name is not valid',
		                validators: {
		                    notEmpty: {
		                        message: 'The Company/Business name is required and cannot be empty'
		                    },
		                    stringLength: {
		                        min: 3,
		                        max: 50,
		                        message: 'The Company/Business name must be more than 3 and less than 50 characters long'
		                    },
		                    regexp: {
		                        regexp: /^[a-z A-Z]+$/,
		                        message: 'The Company/Business name can only consist of alphabets'
		                    }
		                }
		            },
		            'company.phoneNumber': {
		                message: 'The phone number is not valid',
		                validators: {
		                    notEmpty: {
		                        message: 'The phone number is required and cannot be empty'
		                    },
		                    stringLength: {
		                        min: 10,
		                        max: 10,
		                        message: 'The phone number must be of 10 digits'
		                    },
		                    regexp: {
		                        regexp: /^[0-9]+$/
		                    }
		                }
		            },
		            'company.address': {
		                message: 'The address is not valid',
		                validators: {
		                    notEmpty: {
		                        message: 'The address is required and cannot be empty'
		                    },
		                    stringLength: {
		                        min: 3,
		                        max: 50,
		                        message: 'The address must be more than 3 and less than 50 characters long'
		                    },
		                    regexp: {
		                    	regexp: /^[a-z 0-9A-Z,]+$/,
		                        message: 'The Account/Business name can only consist of alphabets,numbers and comma(,)'
		                    }
		                }
		            },
		            uploadimage: {
		            	validators: {
		                    file: {
		                        extension: 'png',
		                        type: 'image/png',
		                        maxSize: 51200,   // 2048 * 1024
		                        message: 'The selected file is not valid'
		                    }
		                }
		            }
	            }
	        })
	        .bootstrapWizard({
	            tabClass: 'nav nav-pills',
	            onTabClick: function(tab, navigation, index) {
	                return false;
	            },
	            onNext: function(tab, navigation, index) {
	            	//var prevTabHeight = $('.tab-content').height();
	            	//$('#tabContentHeight').val(prevTabHeight);
	                var numTabs    = $('#registrationForm').find('.tab-pane').length,
	                    isValidTab = validateTab(index - 1);
	                if (!isValidTab) {
	                    return false;
	                }
	
	                if (index === numTabs) {
	                    // We are at the last tab
	
	                    // Uncomment the following line to submit the form using the defaultSubmit() method
	                    $('#registrationForm').formValidation('defaultSubmit');
	                }
					
	                return true;
	            },
	            onPrevious: function(tab, navigation, index) {
	            	//var prevTabHeight = $('.tab-content').height();
	            	//alert(prevTabHeight);
	            	//$('#tabContentHeight').val(prevTabHeight);
	                return true;
	            },
	            onTabShow: function(tab, navigation, index) {
	            	//var tabHeight = $('#tabContentHeight').val();
	            	//$('.tab-content').height(tabHeight);
	                // Update the label of Next button when we are at the last tab
	                var numTabs = $('#registrationForm').find('.tab-pane').length;
	                $('#registrationForm')
	                    .find('.next')
	                        .removeClass('disabled')    // Enable the Next button
	                        .find('a')
	                        .html(index === numTabs - 1 ? 'Submit' : 'Next');
	
	                //adjustIframeHeight();
	            }
	        });
	
	    function validateTab(index) {
	        var fv   = $('#registrationForm').data('formValidation'), // FormValidation instance
	            // The current tab
	            $tab = $('#registrationForm').find('.tab-pane').eq(index);
	
	        // Validate the container
	        fv.validateContainer($tab);
	
	        var isValidStep = fv.isValidContainer($tab);
	        if (isValidStep === false || isValidStep === null) {
	            // Do not jump to the target tab
	            return false;
	        }
	
	        return true;
	    }
	});