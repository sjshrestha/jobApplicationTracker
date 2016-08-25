var registrationApp = angular.module('registrationApp', []);

registrationApp.controller('registrationController', function ($scope, $http) {

    $scope.init = function (url) {
        $scope.url = url;
    };

    $scope.register = function (user) {
        var msg = isValid(user);
        if (msg != '') {
            alert(msg);
            return;
        }

        $http.post('register', angular.toJson(user))
                .success(function (data) {
                    if (data.message == 'ok') {
                        clear(user);
                        alert('User registered successfully !!!');
                    } else {
                        $scope.error = data.message;
                        alert('Error: ' + data.message);
                    }
                });
    };

    clear = function (user) {
        user.firstName = '';
        user.lastName = '';
        user.email = '';
        user.username = '';
        user.password = '';
        user.repassword = '';
        user.phone = '';
    };

    isValid = function (user) {
        var msg = '';

        if (user == null || user == 'undefined') {
            user = new Object();
        }

        if (user.firstName == null || user.firstName == '')
            msg += 'First name cannot be empyt.\n';
        if (user.lastName == null || user.lastName == '')
            msg += 'Last name cannot be empyt.\n';
        if (user.email == null || user.email == '')
            msg += 'Email cannot be empyt.\n';
        if (user.username == null || user.username == '')
            msg += 'Username cannot be empyt.\n';
        if (user.password == null || user.password == '')
            msg += 'Password cannot be empyt.\n';
        if (user.repassword == null || user.repassword == '')
            msg += 'Re-password cannot be empyt.\n';
        if (user.phone == null || user.phone == '')
            msg += 'Phone cannot be empyt.\n';

        if (user.password != '' && user.repassword != '' && user.password != user.repassword) {
            msg += 'Password and re-password are not same.';
        }

        return msg;
    };
});