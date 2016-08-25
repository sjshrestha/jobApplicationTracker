<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/headerbrand.jsp" %>
<div class="row">
    <div class="col-xs-4 col-xs-offset-1  ">
        <div class="login-panel panel panel-default">
            <div class="panel-heading" id="loginhead">Log in</div>
            <div class="panel-body" id="loginform">
               
                <form id="frmUser" role="form" method="post" action="<c:url value='/login'></c:url>">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Username" name="username" type="text" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">
                                Remember Me </label>
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                        <a href="#" id="forgotpwd" class="btn btn-primary pull-right">Forgot Password</a>
                    </fieldset>
                    <br>
                     <div class="alert-danger">${error}</div>
                </form>
            </div>

            <div class="panel-body" id="forgotpassword">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Enter your email address" name="email" type="email" />
                        </div>
                        <button type="submit" name="forgot" class="btn btn-primary">Retreive Password</button>
                        <a id="backlogin" class="btn btn-primary pull-right">Back to login</a>
                    </fieldset>

                </form>

            </div>


        </div>
    </div>
    <!-- /.col-->
    <div class="col-xs-4 col-xs-offset-1">
        <div class="login-panel panel panel-default" ng-app="registrationApp">
            <div class="panel-heading">Create New Account</div>
            <div class="panel-body" ng-controller="registrationController" ng-init="init('localhost://')">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="First Name" name="fname" type="text" ng-model="user.firstName" required="required">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Last Name" name="lname" type="text" ng-model="user.lastName" required="required">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Email" name="email" type="email" autofocus="" ng-model="user.email" required="required">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Username" name="username" type="text" value="" ng-model="user.username" required="required">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="password" type="password" value="" ng-model="user.password" required="required">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Re-type Password" name="repassword" type="password" value="" ng-model="user.repassword" required="required">
                            {{error}}

                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Phone" name="phone" type="text" value="" ng-model="user.phone" required="required">
                        </div>
                        <button type="submit" class="btn btn-primary" ng-click="register(user)">Sign Up</button>
                    </fieldset>
                </form>
                <pre>user = {{user| json}}</pre>
            </div>
        </div>
    </div>
</div>
<%@include  file="includes/footerbrand.jsp" %>            

<script>

    $(function () {
        $("#forgotpassword").hide();
        $("#forgotpwd").click(function () {
            $("#loginform").hide();
            $("#forgotpassword").show();
            $("#loginhead").html("Forgot Password");
        });

        $("#backlogin").click(function () {
            $("#loginform").show();
            $("#forgotpassword").hide();
            $("#loginhead").html("Login");
        });


    });
</script>