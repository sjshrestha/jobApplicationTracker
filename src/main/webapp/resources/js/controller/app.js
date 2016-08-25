var app = angular.module('angularTable', ['angularUtils.directives.dirPagination']);
app.controller('listdata', function ($scope, $http) {
    $scope.init = function (resourceUrl) {
        vm.url = resourceUrl;
        vm.getData(vm.pageno); // Call the function to fetch initial data on page load.
    };
    
    $scope.$watch(function (scope) {
        return scope.jobTitleFilter;
    },
            function (newValue, oldValue) {
                $scope.jobTitleFilter = newValue;
                vm.getData(vm.pageno); 
                console.log('New value: ' + newValue + ', Old value: ' + oldValue);
            }
    );
    
    var vm = this;
    vm.users = []; //declare an empty array
    vm.pageno = 1; // initialize page no to 1
    vm.total_count = 0;
    vm.itemsPerPage = 3; //this could be a dynamic value from a drop down

    vm.getData = function (pageno) { // This would fetch the data on page change.
        //In practice this should be in a factory.
        vm.users = [];
        var url = vm.url + "/" + vm.itemsPerPage + "/" + pageno;
        $http({url: url, method: "GET", params: {filter: $scope.jobTitleFilter}
        }).success(function (response) {
            vm.users = response.data; //ajax request to fetch data into vm.data
            vm.total_count = response.totalCount;
        });
    };
});