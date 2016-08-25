<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Server Side Pagination in Angular js</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="resources/css/styles.css">
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
    </head>
    <body>
        <div role="main" class="container theme-showcase" ng-app="angularTable">
            <div class="" style="margin-top:90px;">
                <div class="col-lg-8">
                    <div class="page-header">
                        <h2 id="tables">Server Side pagination in Angular js</h2>
                    </div>
                    <div class="bs-component" ng-init="init('getrecords')" ng-controller="listdata as data">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-show="data.users.length <= 0"><td colspan="5" style="text-align:center;">Loading new data!!</td></tr>
                                <tr dir-paginate="user in data.users|itemsPerPage:data.itemsPerPage" total-items="data.total_count">
                                    <td>{{user.firstname}}</td>
                                    <td>{{user.lastname}}</td>
                                </tr>
                            </tbody>
                        </table> 
                        <dir-pagination-controls
                            max-size="8"
                            direction-links="true"
                            boundary-links="true" 
                            on-page-change="data.getData(newPageNumber)" >
                        </dir-pagination-controls>
                    </div>
                </div>
            </div>
        </div>
        <script src="resources/js/controller/dirPagination.js"></script>
        <script src="resources/js/controller/app.js"></script>
    </body>
</html>
