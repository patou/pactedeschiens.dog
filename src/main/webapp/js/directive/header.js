app.directive("header", function(){
    return {
        restrict: 'E',
        templateUrl: 'js/templates/header.html',
        controller: ['$scope', '$timeout', function($scope, $timeout) {
            $scope.toggleMenu = function() {
                angular.element(".top-menu ul").slideToggle("fast", function () {
                });
                $timeout(function() {
                    angular.element(".top-menu ul").slideToggle("fast", function () {
                    });
                }, 2000);
            };
            $scope.launch = function() {
                angular.element("#slider4").responsiveSlides({
                    auto: true,
                    pager: true,
                    nav: false,
                    speed: 500,
                    timeout: 5000,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });
            }
        }]
    };
});