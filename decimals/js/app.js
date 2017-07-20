angular.module('myApp', ['ngTagsInput'])
.controller('MainCtrl', function($scope, $http) {
	$scope.tags = [];
	var list = 	{"cities":[{nome:"Amsterdam", sigla:"AMS"},{nome:"Peru", sigla:"PE"},{nome:"Beijing", sigla: "BEI"},{nome:"Cairo", sigla:"CAI"},{nome:"AREQUIPA", sigla:"AQP"}]}
	$scope.loadTags = function(query, element) {

	};
	


});
