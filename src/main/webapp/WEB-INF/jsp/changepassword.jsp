<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-lock" aria-hidden="true"></i> Change Password</h1>
<form class="form-horizontal" method="post">
     <div class="form-group">
        <label for="" class="col-lg-2">Old Password</label>
        <div class="col-lg-10">
            <input type="password" class="form-control" name="oldpassword"/>
        </div>
    </div>
    
    <div class="form-group">
        <label for="" class="col-lg-2">New Password</label>
        <div class="col-lg-10">
            <input type="password" class="form-control" name="newpassword"/>
        </div>
    </div>
    
      <div class="form-group">
        <label for="" class="col-lg-2">Re Type Password</label>
        <div class="col-lg-10">
            <input type="password" class="form-control" name="repassword"/>
        </div>
    </div>
    
    <div class="form-group">
             <label for="" class="col-lg-2">&nbsp;</label>
        <div class="col-lg-10">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </div>    
    
    
</form>
               
 <%@include  file="includes/footer.jsp" %>                