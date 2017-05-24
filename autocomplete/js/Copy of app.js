var app = angular.module('plunker', ['ngTagsInput']);

app.controller('MainCtrl', function($scope, $http) {
  $scope.tags = [];
  
  $scope.loadCountries = function($query) {
    return $http.get('countries.json', { cache: true}).then(function(response) {
      var countries = response.data;
      return countries.filter(function(country) {
        return country.name.toLowerCase().indexOf($query.toLowerCase()) != -1;
      });
    });
  };
});
