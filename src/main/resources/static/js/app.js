var psoApp = angular.module("psoApp", ["ui.router"]);

psoApp.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise("home");
	
	$stateProvider
		.state('home', {
			url: '/home',
			templateUrl: URLS.partialsHome,
			controller: 'HomeCtrl'
		})
		.state('order', {
			url: '/order',
			templateUrl: URLS.partialsOrder,
			controller: 'OrderCtrl'
		})
		.state('vcap', {
			url: '/vcap',
			templateUrl: URLS.partialsVcap,
			controller: 'MiscCtrl'
		});
});


psoApp.factory("productFactory", function($http) {
	var factory = {};
	factory.getProductList = function() {
		return $http.get(URLS.getProductList);
	};
	factory.getCategoryList = function() {
		return $http.get(URLS.getCategoryList);
	};
	
	return factory;
});

psoApp.factory("miscFactory", function($http) {
	var factory = {};
	factory.getVcapProperties = function() {
		return $http.get(URLS.vcapProperties);
	};
	
	return factory;
});

psoApp.factory("orderFactory", function($http){
	var factory = {};
	factory.getOrderProductList = function() {
		return $http.get(URLS.getOrderProductList);
	};
	
	factory.getProductsCountInCart = function() {
		return $http.get(URLS.productsCount);
	};
	
	factory.addToCart = function(product) {
		var data = {};
		data.product = {};
		data.product.id = product.id;
		return $http.post(URLS.addToCart, data);
	};
	
	factory.updateOrderProduct = function(orderProduct) {
		return $http.post(URLS.updateOrderProduct, orderProduct);
	};
	
	factory.deleteOrderProduct = function(orderProduct) {
		return $http.post(URLS.deleteFromCart, orderProduct);
	};
	return factory;
});

psoApp.controller("HomeCtrl", function($scope, productFactory, orderFactory) {
	function init() {
		$scope.currentCategory="";
		$scope.statusmessage="";
		productFactory.getProductList().success(function(data){
			$scope.products = data;
		});
		
		productFactory.getCategoryList().success(function(data){
			$scope.categories = data;
		});
		
		$scope.updateCartCount();
	}
	
	$scope.updateCartCount = function() {
		orderFactory.getProductsCountInCart().success(function(data) {
			$scope.productsCountInCart = data;
		});		
	};
	
	$scope.showProductsForCategory = function(category) {
		$scope.currentCategory = category.name;
	};
	
	$scope.showForAllCategory = function(category) {
		$scope.currentCategory = "";
	};
	
	$scope.addToCart = function(product) {
		orderFactory.addToCart(product).success(function(data){
			$scope.updateCartCount();
			$scope.statusmessage="Added " + product.name + " to Cart!";
		});
	};
	
	$scope.currentCategoryFilter = function(product) {
		if ($scope.currentCategory==="" || product.category == undefined ) {
			return true;
		}else {
			if (product.category.name === $scope.currentCategory) {
				return true;
			}else {
				return false;
			}
		}
	};
	
	init();
});

psoApp.controller("OrderCtrl", function($scope, orderFactory, $state) {
	function init() {
		$scope.statusmessage="";		
		orderFactory.getOrderProductList().success(function(data) {
			$scope.orderProducts = data;
		});
		$scope.updateCartCount();
	}
	
	$scope.updateCartCount = function() {
		orderFactory.getProductsCountInCart().success(function(data) {
			$scope.productsCountInCart = data;
		});		
	};	
	
	$scope.updateOrderProduct = function(orderProduct) {
		orderFactory.updateOrderProduct(orderProduct).success(function(data) {
			$scope.orderProducts = data;
			$scope.updateCartCount();
			$scope.statusmessage = "Updated order for product " + orderProduct.product.name;
		});
	};
	
	$scope.deleteOrderProduct = function(orderProduct) {
		orderFactory.deleteOrderProduct(orderProduct).success(function(data){
			$scope.orderProducts = data;
			$scope.updateCartCount();
			$scope.statusmessage = "Deleted order for product " + orderProduct.product.name;
		});
	};
	
	init();
});

psoApp.controller("MiscCtrl", function($scope, miscFactory) {
	miscFactory.getVcapProperties().success(function(data) {
		$scope.vcapProperties = data;
	});
});