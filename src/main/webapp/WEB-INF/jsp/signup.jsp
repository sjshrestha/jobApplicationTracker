<%-- 
    Document   : login
    Created on : Apr 17, 2016, 7:50:41 PM
    Author     : rakeshshrestha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Phone Directory</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Gateway to the phone directory </h1>
                    <p>The one and only amazing phone directory</p>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign in</h3>
                    </div>
                    <div class="panel-body">
                        <form:form modelAttribute="newUser">
                            <fieldset>
                                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                                
                                <div class='form-group'>
                                    <form:input class="form-control" placeholder="First name"
                                           path='firstName' type="text" />
                                </div>
                                
                                <div class='form-group'>
                                    <form:input class="form-control" placeholder="Last name"
                                           path='lastName' type="text" />
                                </div>
                                
                                <div class='form-group'>
                                    <form:input class="form-control" placeholder="Email"
                                           path='email' type="text" />
                                </div>
                                
                                <div class='form-group'>
                                    <form:input class="form-control" placeholder="Phone"
                                           path='phone' type="text" />
                                </div>
                                                             
                                <div class='form-group'>
                                    <form:input class="form-control" placeholder="User name"
                                           path='username' type="text" />
                                </div>
                                
                                <div class="form-group">
                                    <form:input class='form-control' placeholder="Password"
                                           path='password' type="password" />
                                    <form:errors path="password" cssClass="text-danger"/>
                                </div>
                                
                                <div class="form-group">
                                    <input class='form-control' placeholder="Password"
                                           name='confirm_password' type="password" />
                                    <form:errors name="confirm_password" cssClass="text-danger"/>
                                </div>
                                        
                                                             
                                                                
                                <input class="btn btn-lg btn-success btn-block"
                                       type="submit" value="register"/>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
