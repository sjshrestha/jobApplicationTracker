<%-- 
    Document   : newjob
    Created on : Jul 12, 2016, 11:30:04 PM
    Author     : Dilip
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1 class="page-header"><i class="fa fa-cubes" aria-hidden="true"></i> Add log</h1>
<a href="../applyjob" class="btn btn-primary pull-right dashboardbtn">Back to Apply Job</a>


<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-6">

        <form:form modelAttribute="jobLog" class="form-horizontal" role="form">

            <div class="form-group">

                <input class="form-control" placeholder="Enter Title" name="title" type="text" autofocus="">
            </div>
            <div class="form-group">
                <textarea class="form-control" placeholder="Enter Comment" name="comment" rows="5"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Add Log</button>

        </form:form>


    </div>
</div>


<script src="<c:url value='/resources/js/controller/jobController.js'></c:url>"></script>
<%@include  file="includes/footer.jsp" %>
