function init_map() {
        var var_location = new google.maps.LatLng(12.955954,77.714764);
 
        var var_mapoptions = {
          center: var_location,
          zoom: 14
        };
 
        var var_marker = new google.maps.Marker({
            position: var_location,
            map: var_map,
            title:"Accountmate Inc."});
 
        var var_map = new google.maps.Map(document.getElementById("map-container"),
            var_mapoptions);
 
        var_marker.setMap(var_map);    
 
      }
 
google.maps.event.addDomListener(window, 'load', init_map);

$(document).ready(function() {
    $('#contactForm').formValidation({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	contactname: {
                message: 'The contact name is not valid',
                validators: {
                    notEmpty: {
                        message: 'The contact name is required and cannot be empty'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: 'The contact name must be more than 3 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z ]+$/,
                        message: 'The contact name can only consist of alphabets'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The email address is not a valid'
                    }
                }
            },
             message: {
                message: 'The message is not valid',
                validators: {
                    notEmpty: {
                        message: 'The message is required and cannot be empty'
                    },
                    stringLength: {
                        min: 3,
                        max: 300,
                        message: 'The message must be more than 3 and less than 300 characters long'
                    }
                }
            }
        }
    });
});