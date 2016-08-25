<%-- 
    Document   : home
    Created on : Jul 11, 2016, 5:45:11 PM
    Author     : suraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>

<h1 class="page-header"><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</h1>

<div class="row">
    <div class="col-lg-6">
        <canvas id="myChart"></canvas>
    </div>
    <div class="col-lg-6">
        <canvas id="chart-area" />
    </div>    

<div class="col-lg-12">
    <h3>Recent Activities</h3>
</div>

<div class="col-md-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Apply Jobs
        </div>
        <div class="panel-body">
            <c:forEach items="${applyjobs}" var="job" begin="0" end="5">
            <div class="box">
                <h3><a href="<c:url value='/applyjob/viewJobDetails?jobId=${job.id}'></c:url>">${job.companyName}</a></h3>
                <span class="text-italic">${job.jobTitle}</span> <br> 
                <span class="text-date">${job.appliedDate}</span> 
            </div>
            </c:forEach>
           

        </div>
    </div>
</div> <!-- panel -->


<div class="col-md-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Latest Events
        </div>
        <div class="panel-body">
             <c:forEach items="${latestEvents}" var="event" begin="0" end="5">
            <div class="box">
                <h3>${event.eventName}</h3>
                
                <span class="text-date">${event.eventDate}</span> 
            </div>
             </c:forEach> 
            

        </div>
    </div>
</div> <!-- panel -->



<div class="col-md-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Bookmark
        </div>
        <div class="panel-body">
            <div class="box">
                <h3>Monster.com</h3>
                <span class="text-italic">U.S. and international</span> <br> 
                
            </div>

            <div class="box">
                <h3>Oodle</h3>
                <span class="text-italic">U.S.</span> <br> 
                
            </div>

            <div class="box">
                <h3>Proven</h3>
                <span class="text-italic">U.S.</span> <br> 
                
            </div>


        </div>
    </div>
</div> <!-- panel -->
<div class="row">
<div class="col-lg-8">
    <h3>Upcoming Events Calendar</h3>
    

	<div id='calendar'></div>
</div>
</div>


</div> <!-- row -->

<%@include  file="includes/footer.jsp" %>                

<script>
    var data = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "Total Apply Job",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "Total Event",
                fillColor: "rgba(151,187,205,0.2)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

    var config = {
        type: 'doughnut',
        data: {
            datasets: [{
                    data: [
                        50,
                        70,
                        80,
                        90,
                        88,
                    ],
                    backgroundColor: [
                        "#F7464A",
                        "#46BFBD",
                        "#FDB45C",
                        "#949FB1",
                        "#4D5360",
                    ],
                    label: 'Dataset 1'
                }],
            labels: [
                "Spring MVC",
                "ASP.NET",
                "Java",
                "Big Data",
                "Database"
            ]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Apply Job By Category'
            },
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    };






    window.onload = function () {

        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myDoughnut = new Chart(ctx, config);

        var ctx = document.getElementById("myChart").getContext("2d");
        window.myBar = new Chart(ctx, {
            type: 'bar',
            data: data,
            options: {
                elements: {
                    rectangle: {
                        borderWidth: 2,
                        borderColor: 'rgb(0, 255, 0)',
                        borderSkipped: 'bottom'
                    }
                },
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: 'Job and Events '
                }
            }
        });

    };
    
    
    $(document).ready(function() {

		$('#calendar').fullCalendar({
			defaultDate: '2016-06-12',
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: [
				{
					title: 'All Day Event',
					start: '2016-06-01'
				},
				{
					title: 'Long Event',
					start: '2016-06-07',
					end: '2016-06-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-06-09T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-06-16T16:00:00'
				},
				{
					title: 'Conference',
					start: '2016-06-11',
					end: '2016-06-13'
				},
				{
					title: 'Meeting',
					start: '2016-06-12T10:30:00',
					end: '2016-06-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2016-06-12T12:00:00'
				},
				{
					title: 'Meeting',
					start: '2016-06-12T14:30:00'
				},
				{
					title: 'Happy Hour',
					start: '2016-06-12T17:30:00'
				},
				{
					title: 'Dinner',
					start: '2016-06-12T20:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2016-06-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2016-06-28'
				}
			]
		});
		
	});
</script>