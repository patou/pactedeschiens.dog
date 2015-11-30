app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            controller: function () {
                window.location.replace('/');
            }
        })
        .when("/index.html", {
            controller: function () {
                window.location.replace('/');
            }
        })
        .when("/about.html", {
            controller: function () {
                window.location.replace('/about.html');
            }
        })
        .when("/about", {
            controller: function () {
                window.location.replace('/about.html');
            }
        })
        .when("/blog.html", {
            templateUrl: "templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog.html/", {
            templateUrl: "templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog", {
            templateUrl: "templates/bloghome.html",
            controller: "BlogController"
        })
        .when("/blog/:id", {
            templateUrl: "templates/post.html",
            controller: "BlogController"

        })
        .when("/contact.html", {
            controller: function () {
                window.location.replace('/contact.html');
            }
        })
        .when("/contact", {
            controller: function () {
                window.location.replace('/contact.html');
            }
        })
        .when("/partenaires.html", {
            controller: function () {
                window.location.replace('/partenaires.html');
            }
        })
        .when("/partenaires", {
            controller: function () {
                window.location.replace('/partenaires.html');
            }
        })
        .otherwise({redirectTo: '/'});
});