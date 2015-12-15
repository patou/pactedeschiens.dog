app.directive("smallheader", function($timeout){
    return {
        restrict: 'E',
        templateUrl: 'js/templates/smallheader.html',
        controller: ['$scope', function($scope) {
            $scope.toggleMenu = function() {
                angular.element(".top-menu ul").slideToggle("slow", function () {
                });
                $timeout(function() {
                    angular.element(".top-menu ul").slideToggle("slow", function () {
                    });
                }, 2000);
            }
        }]
    };

});