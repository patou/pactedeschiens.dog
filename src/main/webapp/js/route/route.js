app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "js/templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog.html", {
            templateUrl: "js/templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog", {
            templateUrl: "js/templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog/:id", {
            templateUrl: "js/templates/post.html",
            controller: "BlogController"

        })
        .otherwise({redirectTo: '/'});
});