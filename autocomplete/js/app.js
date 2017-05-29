angular.module('myApp', ['ngTagsInput'])
.controller('MainCtrl', function($scope, $http) {
	$scope.tags = [];
	var list = 	{"cities":[{nome:"Amsterdam", sigla:"AMS"},{nome:"Peru", sigla:"PE"},{nome:"Beijing", sigla: "BEI"},{nome:"Cairo", sigla:"CAI"},{nome:"AREQUIPA", sigla:"AQP"}]}
	$scope.loadTags = function(query, element) {
		if (query != '' && query !=  null){
			return list.cities.filter(function(datalist) {
				if (datalist.nome.toLowerCase().indexOf(query.toLowerCase()) >= 0){
					return datalist;
				}
			});
		} else {
			return list.cities;
		}
	};
	
	$scope.checkAddElement = function(tag, element){
		if (element.tags.length == 0){
			document.getElementById('nome').style.width = 70 + (tag.nome.length * 7) + 'px';			
			return true;
		} else {
			return false;
		}
	};
	
	$scope.addElement = function() {
		$scope.tags.push({ sigla: 'aaa', nome: 'cc'});
	}

	$scope.save = function(){
		angular.forEach($scope.tags, function(tag){
			//alert("nome: " + tag.nome + " , sigla: " + tag.sigla);
		});
	}
});
