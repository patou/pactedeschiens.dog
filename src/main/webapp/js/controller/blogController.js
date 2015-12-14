app.controller('BlogController', function ($scope, $http, $routeParams) {
    $scope.$parent.homeHeader = false;
    if ($routeParams.id) {
        $http.get("js/articles.json")
            .success(function(data){
                $scope.article = data[0];
            })
            .error(function(error){
                console.error("Error wile fetching json " + error);
            });
    } else {
        $http.get("js/articles.json")
            .success(function(data){
                $scope.articles = data;
            })
            .error(function(error){
                console.error("Error wile fetching json " + error);
            });

    }

});
