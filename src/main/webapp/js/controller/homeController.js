app.controller('HomeController', function ($scope, $http) {
    $scope.$parent.homeHeader = true;
    $http.get("/api/blog")
        .success(function(data){
            $scope.articles = data;
        })
        .error(function(error){
            console.error("Error wile fetching json " + error);
        });


});
