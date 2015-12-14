app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "js/templates/home.html",
            controller: "HomeController"
        })
        .when("/home", {
            templateUrl: "js/templates/home.html",
            controller: "HomeController"
        })
        .when("/presentation", {
            templateUrl: "js/templates/about.html",
            controller: "AboutController"
        })
        .when("/blog", {
            templateUrl: "js/templates/blog.html",
            controller: "BlogController"
        })
        .when("/blog/:id", {
            templateUrl: "js/templates/post.html",
            controller: "BlogController"
        })
        .when("/contact", {
            templateUrl: "js/templates/contact.html",
            controller: "MessageController"
        })
        .when("/partenaires", {
            templateUrl: "js/templates/partenaires.html",
            controller: "PartenairesController"
        })
        .otherwise({redirectTo: '/'});
    $locationProvider.html5Mode(true);

});