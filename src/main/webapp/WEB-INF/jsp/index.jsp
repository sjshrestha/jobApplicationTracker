<%-- 
    Document   : index
    Created on : Jul 11, 2016, 3:34:53 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Example - example-example33-production</title>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
    </head>
    <body ng-app="formExample">
        <div ng-controller="ExampleController">
            <form novalidate class="simple-form">
                Name: <input type="text" ng-model="user.name" /><br />
                E-mail: <input type="email" ng-model="user.email" /><br />
                Gender: <input type="radio" ng-model="user.gender" value="male" />male
                <input type="radio" ng-model="user.gender" value="female" />female<br />
                <input type="button" ng-click="reset()" value="Reset" />
                <input type="submit" ng-click="update(user)" value="Save" />
                <input type="button" ng-click="edit()" value="Edit Programatically" />
            </form>
            <pre>user = {{user| json}}</pre>
            <pre>master = {{master| json}}</pre>
        </div>

        <script>
            angular.module('formExample', [])
                    .controller('ExampleController', ['$scope', function ($scope) {
                            $scope.master = {};

                            $scope.update = function (user) {
                                $scope.master = angular.copy(user);
                            };
                            
                            $scope.edit = function () {
                                $scope.user.name = 'Suraj Shrestha';
                                $scope.user.email = 'shrestha.sj.npl@gmail.com';
                            };

                            $scope.reset = function () {
                                $scope.user = angular.copy($scope.master);
                            };

                            $scope.reset();
                        }]);
        </script>
    </body>
</html>

<!-- 
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
-->