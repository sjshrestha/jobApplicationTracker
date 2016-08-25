<%-- 
    Document   : newjobschedule
    Created on : Jul 13, 2016, 6:04:06 PM
    Author     : Dilip
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-calendar" aria-hidden="true"></i> Job Scheduling</h1>
<a href="jobscheduling" class="btn btn-primary pull-right dashboardbtn">Back to Job Schedule</a>

<div>
    <form:form modelAttribute="newJobSchedule"  class="form-horizontal">
        <fieldset>

            <legend>Add new job schedule</legend>
            <div class="form-group">
                <label class="col-lg-2">Job Apply</label>
                <div class="col-lg-8">
                    <form:select path="selectedJobCategory" cssClass="form-control">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${jobList}" itemLabel="jobTitle" itemValue="id" />
                    </form:select>
                    
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2">Event Date:</label>
                <div class="col-lg-8">
                    <form:input id="eventDate" path="eventDate" type="text" cssClass="form-control"/>
                    <form:errors path="eventDate" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2">Remind Me Before:</label>
                <div class="col-lg-8">
                    <form:input id="remindDayBefore" path="remindDayBefore" type="text" cssClass="form-control"/>
                    <form:errors path="remindDayBefore" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2">Comment: </label>
                <div class="col-lg-8">
                    <form:textarea id="comment" path="comment" rows="2" cssClass="form-control"/>
                </div>
            </div>
            <div class="form-group"> 
                <label class="col-lg-2">&nbsp;</label>
                <div class="col-lg-8">
                    Remind Me <form:checkbox  id="remindMe" path="remindMe"/>
                </div>
            </div>
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value ="Save Job Schedule"/>
            </div>
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        </fieldset>
    </form:form>
</div>

<%@include  file="includes/footer.jsp" %>                

