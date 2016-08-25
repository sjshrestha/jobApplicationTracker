<%-- 
    Document   : index
    Created on : Jul 11, 2016, 3:34:53 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Example - example-example33-production</title>
        <style>
            body     { padding-top:30px; }
        </style>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
        <script src="resources/js/controller/registrationController.js"></script>
    </head>
    <body ng-app="registrationApp">
        <div ng-controller="registrationController" ng-init="init('localhost://')">
            <form>
                First name: <input type="text" ng-model="user.firstName" required /><br />
                Last name: <input type="text" ng-model="user.lastName" required /><br />
                Email: <input type="email" ng-model="user.email" required /><br/>
                Username: <input type="text" ng-model="user.usesrname" required /><br/>
                Password: <input type="password" ng-model="user.password" required /><br/>
                Re password: <input type="password" ng-model="user.repassword" required name="repassword"/><br/>
                Phone: <input type="text" ng-model="user.phone" required /><br/>

                <input type="button" ng-click="register(user)" value="Register" />
            </form>
            <pre>user = {{user| json}}</pre>
        </div>
    </body>
</html>