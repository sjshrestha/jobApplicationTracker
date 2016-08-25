<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-calendar" aria-hidden="true"></i> Job Scheduling</h1>
<a href="newjobschedule" class="btn btn-primary pull-right dashboardbtn">New Schedule</a>
 
<table class="table table-bordered">
     <tr>
         <th>Schedule Id</th>
         <th>Job Opening Id</th>
         <th>Event date</th>
         <th>Remind Date before (days)</th>
         <th>Remind Date</th>
         <th>Comment</th>
     </tr>
     <c:forEach items="${allJobs}" var="jobschedule">
         <tr>
         <td>${jobschedule.id}</td>
         <td>${jobschedule.id}</td>
         <td>${jobschedule.eventDate}</td>
         <td>${jobschedule.remindDayBefore}</td>
         <td>${jobschedule.remindDate}</td>
         <td>${jobschedule.comment}</td>
     </tr>
     </c:forEach>
 </table>
 <%@include  file="includes/footer.jsp" %>                
 
