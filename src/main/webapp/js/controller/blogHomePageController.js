app.controller('BlogHomePageController', function ($scope, $http) {
    $scope.$parent.homeHeader = false;
    $http.get("/api/blog")
        .success(function(data){
            $scope.articles = data;
        })
        .error(function(error){
            console.error("Error wile fetching json " + error);
        });

});
