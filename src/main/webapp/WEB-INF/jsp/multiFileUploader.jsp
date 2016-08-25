<%-- 
    Document   : multiFileUploader
    Created on : Jul 13, 2016, 12:46:11 AM
    Author     : Dilip
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-gears" aria-hidden="true"></i> Resources</h1>
<a href="#" class="btn btn-primary pull-right dashboardbtn">Upload Resources</a>
    <div class="form-container">
        
        <form:form method="POST" modelAttribute="multiFileBucket" enctype="multipart/form-data" class="form-horizontal">
         
            <c:forEach var="v" varStatus="vs" items="${multiFileBucket.files}">
                <form:input type="file" path="files[${vs.index}].file" id="files[${vs.index}].file" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="files[${vs.index}].file" class="help-inline"/>
                </div>
            </c:forEach>
            <br/>
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>
         
        <br/>
       
    </div>
<%@include  file="includes/footer.jsp" %>