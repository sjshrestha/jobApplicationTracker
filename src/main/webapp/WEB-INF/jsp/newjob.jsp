<%-- 
    Document   : newjob
    Created on : Jul 12, 2016, 11:30:04 PM
    Author     : Dilip
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>


<h1 class="page-header"><i class="fa fa-cubes" aria-hidden="true"></i> Apply Job</h1>
<a href="../applyjob" class="btn btn-primary pull-right dashboardbtn">Back to Apply Job</a>
<div ng-app="jobApp">
    <div ng-controller="jobController" ng-init="init('localhost://')">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Job title:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.jobTitle" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Company Name</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.companyName" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Company address:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.companyAddress" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Position title:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.positionTitle" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Job description:</label>
                <div class="col-lg-10">
                    <textarea ng-model="job.jobDescription" class="form-control" rows="5"></textarea>
                    <!--<input type="text" class="form-control"  required />-->
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Apply date:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.appliedDate" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Contact person:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.contactPerson" required />
                </div>
            </div>

            <div class="form-group">
                <label for="jobTitle" class="col-lg-2">Contact no:</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" ng-model="job.contactNumber" required />
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" ng-click="addJob(job)">Save</button>
                </div>
            </div>


        </form>
    </div>
</div>
<%@include  file="includes/footer.jsp" %>   
<script src="<c:url value='/resources/js/controller/jobController.js'></c:url>"></script>