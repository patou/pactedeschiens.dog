app.controller('BlogHomePageController', function ($scope, $http) {

    $http.get("js/articles.json")
        .success(function(data){
            $scope.articles = data;
        })
        .error(function(error){
            console.error("Error wile fetching json " + error);
        });

});
