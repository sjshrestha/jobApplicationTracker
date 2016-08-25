<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>

<h1 class="page-header"><i class="fa fa-cubes" aria-hidden="true"></i> Apply Job</h1>
<a href="applyjob/addjob" class="btn btn-primary pull-right dashboardbtn">New Job Record</a>
<div class="row">
    <div class="col-lg-6">Job Log</div>
    <div class="col-lg-6">Job</div>
    <div class="col-lg-6">

        <c:forEach items="${job.logs}" var = "jobLog">
            <div class="box">

                <h5>${jobLog.title}</h5>
                <p>${jobLog.comment}</p>
            </div>
        </c:forEach>


    </div>

    <div class="col-lg-6">
        <div class="bg-info" style="border:2px solid #green;border-radius: 5px;padding:5px;">
        <h3>${job.jobTitle}</h3>
        <p>${job.jobDescription}</p>
        <div><b>${job.companyName}</b></div>
        <div>${job.companyAddress}</div>
        <div>${job.appliedDate}</div>
        <div>${job.contactPerson}</div>
        <div>${job.contactNumber}</div>
        </div>
    </div>

</div>

</div>
</div>
</div>
</div>
<%@include  file="includes/footer.jsp" %>