angular.module('fizzbuzz', [])
.controller('AppController', function ($scope, $http) {
	
	$scope.inputChange = function (input){
		$http.get('http://fizzbuzz.zveayz7b43.ap-southeast-1.elasticbeanstalk.com/api/game/'+userInput.value).
        then(function(response) {
        	$scope.output = response.data;
        }, function(response){
        	$scope.output = "Invalid input";
       });
	}
	
});