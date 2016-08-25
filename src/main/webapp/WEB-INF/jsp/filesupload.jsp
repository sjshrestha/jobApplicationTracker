<%-- 
    Document   : welcome
    Created on : Jul 13, 2016, 12:47:10 AM
    Author     : Dilip
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-gears" aria-hidden="true"></i> Resources</h1>
<a href="#" class="btn btn-primary pull-right dashboardbtn">Upload Resources</a>

<div class="form-container">
    <p>Click on below links to upload single file or multiple files</p><br/><br/>

      <a href="<c:url value='multiUpload' />">Multi File Upload</a>
</div>
<%@include  file="includes/footer.jsp" %>
