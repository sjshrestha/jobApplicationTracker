<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-user" aria-hidden="true"></i> User Profle</h1>

<form class="form-horizontal" method="post">
    <div class="form-group">
        <label for="" class="col-lg-2">First Name</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" name="firstname" value="${sessionScope.user.firstName}" />
        </div>
    </div>
    <div class="form-group">
        <label for="" class="col-lg-2">Last Name</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" name="lastname" value="${sessionScope.user.lastName}" />
        </div>
    </div>
        
        
     <div class="form-group">
        <label for="" class="col-lg-2">Email</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" name="email" value="${sessionScope.user.email}" />
        </div>
    </div>
        
    <div class="form-group">
        <label for="" class="col-lg-2">Phone</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" name="phone" value="${sessionScope.user.phone}" />
        </div>
    </div>    
        
    <div class="form-group">
        <label for="" class="col-lg-2">Username</label>
        <div class="col-lg-10">
            <input type="text" class="form-control" name="username" value="${sessionScope.user.username}" readonly />
        </div>
    </div>    
    
         <div class="form-group">
             <label for="" class="col-lg-2">&nbsp;</label>
        <div class="col-lg-10">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>    
        

</form>


<%@include  file="includes/footer.jsp" %>                