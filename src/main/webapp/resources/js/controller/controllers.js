var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function($scope, $http){
    $scope.refreshCart = function(){
        $http.get('/edu.mum.webstore0.9_base_REST/rest/cart/'+$scope.cartId)
                .success(function(data){
                    $scope.cart = data;
        });
    };
    
    $scope.clearCart = function(){
        $http.delete('/edu.mum.webstore0.9_base_REST/rest/cart/'+$scope.cartId)
                .sucess($scope.refreshCart());
    };
    
    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };
    
    $scope.addToCart = function (productId){
        $http.put('/edu.mum.webstore0.9_base_REST/rest/cart/add/'+productId)
                .success(function (){
                    alert ("Product Successfully added to the Cart!");
                });
    };
    
    $scope.removeFromCart = function(productId){
        $http.put('/edu.mum.webstore0.9_base_REST/rest/cart/remove/'+productId)
                .success(function (){
                    $scope.refreshCart();
        });
    };
});