$(function() {
    var $registerForm = $("#register");

    $registerForm.validate({
        rules: {
            name: {
                required: true,
                lattersonly: true
            },
            email: {
                required: true,
                email: true
            },
            mno: {
                required: true,
                numericonly: true,
                minlength: 10,
                maxlength: 12
            },
            gender: {
                required: true
            },
            state: {
                required: true
            },
            dname: {
                required: true
            },
            profession: {
                required: true
            },
            city: {
                required: true
            },
            address: {
                required: true
            },
            dob: {
                required: true
            },
            password: {
                required: true,
                all: true
            }
        },
        messages: {
            username: {
                required: 'username must be required',
                lattersonly: 'invalid name'
            },

            email: {
                required: 'email must be required',
                email: 'email invalid'
            },
            mno: {
                required: 'phno must be required',
                numericonly: 'Phno invalid',
                minlength: 'min 10 digit',
                maxlength: 'mx 12 digit'
            },
            gender: {
                required: 'gender must be required'
            },
            state: {
                required: 'State must be required'
            },
            city: {
                required: 'City must be required'
            },
            address: {
                required: 'address must be required'
            },
            dname: {
                required: 'Department Name must be required'
            },
            profession: {
                required: 'Profession must be required'
            },
            dob: {
                required: 'DOB must be required'
            },
            password: {
                required: 'password must be required',
                all: 'space is not allowed'
            }
        },
        errorPlacement: function(error, element) {
            if (element.is(":radio")) {
                error.appendTo(element.parents(".gen"));
            } else {
                error.insertAfter(element);
            }
        }
    })

    jQuery.validator.addMethod('lattersonly', function(value, element) {
        return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
    });

    jQuery.validator.addMethod('numericonly', function(value, element) {
        return /^[0-9]+$/.test(value);
    });

    jQuery.validator.addMethod('all', function(value, element) {
        return /^[^-\s][a-zA-Z0-9_\s-]+$/.test(value);
    });
})