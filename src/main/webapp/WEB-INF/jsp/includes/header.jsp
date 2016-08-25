<%@page import="mum.waa.jobapplicationtracker.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Job Tracker Application</title>

        <link href='<c:url value="/resources/css/bootstrap.css"></c:url>' rel="stylesheet">
        <!--<link href='<c:url value="/resources/css/datepicker3.css"></c:url>' rel="stylesheet">-->
        <link href="<c:url value='/resources/css/font-awesome.min.css'></c:url>" rel="stylesheet">
        
        <link href="<c:url value='/resources/css/styles.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/resources/css/fullcalendar.css'></c:url>" rel="stylesheet">
       
            <!--[if lt IE 9]>
            <script src="<c:url value='/resources/js/html5shiv.js'></c:url>"></script>
            <script src="<c:url value='/resources/js/respond.min.js'></c:url>"></script>
            <![endif]-->

    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span>Job</span>Tracker</a>
                    <ul class="user-menu">

                        <li class="dropdown pull-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                                &nbsp; <i class="fa fa-user" aria-hidden="true"></i> Welcome User: <%
                                    if(session.getAttribute("user")==null) {
                                        //response.sendRedirect("login");
                                        out.println("<script>window.location.href='login';</script>");
                                    } else {
                                    User u = (User)session.getAttribute("user");
                                    
                                    out.println(u.getUsername());
                                    }
                                    %> <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<c:url value='/userprofile'></c:url>"> <i class="fa fa-user" aria-hidden="true"></i> Profile</a></li>
                                <li><a href="<c:url value='/settings'></c:url>"> <i class="fa fa-puzzle-piece" aria-hidden="true"></i> Settings</a></li>
                                <li><a href="<c:url value='/logout'></c:url>"> <i class="fa fa-sign-out" aria-hidden="true"></i> Logout</a></li>
                            </ul>
                        </li>

                    </ul>
                </div>

            </div><!-- /.container-fluid -->
        </nav>

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <form role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
            <ul class="nav menu">
                <li><a href="<c:url value='/dashboard'></c:url>"> <i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</a></li>
                <li><a href="<c:url value='/applyjob'></c:url>"><i class="fa fa-cubes" aria-hidden="true"></i> Apply Job Records</a></li>
                <li><a href="<c:url value='/jobscheduling'></c:url>"><i class="fa fa-calendar" aria-hidden="true"></i> Job Scheduling</a></li>
                <li><a href="<c:url value='/userfaq'></c:url>"> <i class="fa fa-cogs" aria-hidden="true"></i> Resources (FAQ's)</a></li>
                <li><a href="<c:url value='/userprofile'></c:url>"> <i class="fa fa-user" aria-hidden="true"></i> User Profile</a></li>
                <li><a href="<c:url value='/changepassword'></c:url>"> <i class="fa fa-lock" aria-hidden="true"></i> Change Password</a></li>
                <li><a href="<c:url value='/settings'></c:url>"> <i class="fa fa-puzzle-piece" aria-hidden="true"></i> Settings</a></li>			
                <li role="presentation" class="divider"></li>
                <li><a href="<c:url value='/logout'></c:url>"> <i class="fa fa-sign-out" aria-hidden="true"></i> Log Out</a></li>
                <li><a href="<c:url value='/help'></c:url>"> <i class="fa fa-info" aria-hidden="true"></i> Help</a></li>
                <li><a href="<c:url value='/aboutus'></c:url>"><i class="fa fa-users" aria-hidden="true"></i> About Us</a></li>
                <li><a href="<c:url value='/tutorials'></c:url>"><i class="fa fa-video-camera" aria-hidden="true"></i> Video Tutorials</a></li>

            </ul>

        </div><!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">

                    <li class="active">&nbsp;   </li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
