angular.module('myApp', ['ngTagsInput'])
.controller('MainCtrl', function($scope, $http) {
	$scope.tags = [];
	var list = ["Amsterdam","Washington","Sydney","Beijing","Cairo","cairo new", "joSe Paulo"];
	$scope.loadTags = function(query) {
		if (query != '' && query !=  null){
			//return $http.get('/tags?query=' + query);
			return list.filter(function(datalist) {
				if (datalist.toLowerCase().indexOf(query.toLowerCase()) >= 0){
					return datalist;
				}
			});
		} else {
			return list;
		}
	};
});
