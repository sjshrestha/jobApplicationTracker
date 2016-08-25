<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : lokex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>


<h1 class="page-header"><i class="fa fa-cubes" aria-hidden="true"></i> Apply Job</h1>
<p>
<div ng-app="jobApp">
    <div ng-controller="jobController" ng-init="init('localhost://')">
        <form>
            Job title: <input type="text" ng-model="job.jobTitle" required /><br />
            Company name: <input type="text" ng-model="job.companyName" required /><br />
            Company address: <input type="text" ng-model="job.companyAddress" required /><br />
            Position title: <input type="text" ng-model="job.positionTitle" required /><br />
            Job description: <input type="text" ng-model="job.jobDescription" required /><br />
            Apply date: <input type="text" ng-model="job.appliedDate" required /><br />
            Contact person: <input type="text" ng-model="job.contactPerson" required /><br />
            Contact no: <input type="text" ng-model="job.contactNumber" required /><br />

            <input type="button" ng-click="addJob(job)" value="Save" />
        </form>
    </div>
</div>
</p>

<%@include  file="includes/footer.jsp" %>   
<script src="resources/js/controller/jobController.js"></script>