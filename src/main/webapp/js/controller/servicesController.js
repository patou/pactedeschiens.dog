app.controller('ServicesController', function ($scope) {
    $scope.$parent.homeHeader = false;

    $scope.toggle = function(id) {
        angular.element("#"+id).slideToggle("fast", function () {
        });
    }
});
