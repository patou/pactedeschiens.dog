app.controller('MessageController', function ($scope, $http, $log) {


    $scope.send = function() {
      sendMessage();
    };

    var sendMessage = function () {
        $http.post('/api/message', {firstName:$scope.firstName, lastName:$scope.lastName, email:$scope.email, message:$scope.message}).
            success(function(data, status, headers, config) {
            }).
            error(function(data, status, headers, config) {
                $log.info('Message dismissed at: ' + new Date());
            });
    }
});
