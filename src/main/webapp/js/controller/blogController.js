app.controller('BlogController', function ($scope, $http, $routeParams) {
    $scope.$parent.homeHeader = false;
    if ($routeParams.id) {
        $http.get("/api/blog/" + $routeParams.id)
            .success(function(data){
                $scope.article = data;
            })
            .error(function(error){
                console.error("Error wile fetching json " + error);
            });
    } else {
        $http.get("/api/blog")
            .success(function(data){
                $scope.articles = data;
            })
            .error(function(error){
                console.error("Error wile fetching json " + error);
            });

    }

});
