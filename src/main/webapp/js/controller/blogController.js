app.controller('BlogController', function ($scope, $http, $routeParams) {

    if ($routeParams.id) {
        //on charge le contenu de l'article sinon ...
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
