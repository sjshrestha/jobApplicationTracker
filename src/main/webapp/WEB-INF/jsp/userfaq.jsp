<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-gears" aria-hidden="true"></i> Resources</h1>
<a href="filesupload" class="btn btn-primary pull-right dashboardbtn">Upload Resources</a>


<c:forEach var="fileName" items="${fileList}">
    <a href="file:///C:/tmp/${fileName}">${fileName}></a><br/>
</c:forEach>
<%@include  file="includes/footer.jsp" %>                