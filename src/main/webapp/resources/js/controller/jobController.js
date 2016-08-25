var jobApp = angular.module('jobApp', []);

jobApp.controller('jobController', function ($scope, $http) {

    $scope.init = function (url) {
        $scope.url = url;
    };

    $scope.addJob = function (job) {
        var msg = isValid(job);
        if (msg != '') {
            alert(msg);
            return;
        }

        $http.post('addjob/', angular.toJson(job))
                .success(function (data) {
                    alert('Job saved successfully !!!');
                    var loc = window.location;

                    var filename = loc.pathname.split("/");
                    window.location = window.location.origin +'/' + filename[1] + '/applyjob';
                }).error(function (data) {
            alert(data)
        });
    };

    isValid = function (job) {
        var msg = '';

        if (job == null || job == 'undefined') {
            job = new Object();
        }

        if (job.jobTitle == null || job.jobTitle == '')
            msg += 'Job Title cannot be empty.\n';
        if (job.companyName == null || job.companyName == '')
            msg += 'Please provide company name.\n';
        if (job.companyAddress == null || job.companyAddress == '')
            msg += 'Please provide company address.\n';
        if (job.positionTitle == null || job.positionTitle == '')
            msg += 'Please provide title of the position.\n';
        if (job.jobDescription == null || job.jobDescription == '')
            msg += 'Please provide job description.\n';
        //if(job.appliedDate == null || job.appliedDate == '')
        //    msg += 'Please provide job applied date.\n';
        if (job.contactPerson == null || job.contactPerson == '')
            msg += 'Please provide contact person for the job.\n';
        if (job.contactNumber == null || job.contactNumber == '')
            msg += 'Please provide contact number.\n';

        return msg;
    };
});