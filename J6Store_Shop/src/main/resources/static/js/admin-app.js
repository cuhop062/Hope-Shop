var app = angular.module("admin-app",["ngRoute"]);

app.config(function ($routeProvider){
    $routeProvider
    .when("/product",{
        templateUrl:"/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/sales",{
        templateUrl:"/admin/sale/sales.html",
        controller: "sales-ctrl"
    })
    .when("/category",{
        templateUrl:"/admin/category/index.html",
        controller: "category-ctrl"
    })
    .when(
        '/statistics', {
            templateUrl: '/admin/statistics/index.html',
            controller: 'statistics-ctrl'
        })
    .when("/order",{
        templateUrl:"/admin/order/index.html",
        controller: "order-ctrl"
    })
    .when("/order/:orderId",{
        templateUrl:"/admin/order/details.html",
        controller: "details-ctrl",
        $Params:'orderId'
    })
    .when("/dashboard",{
        templateUrl:"/admin/dashboard/dashboard.html",
        controller: "dashboard-ctrl"
    })
    .when("/authority",{
        templateUrl:"/admin/authority/authority.html",
        controller: "authority-ctrl"
    })
    .when("/unauthorized",{
        templateUrl:"/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
       redirectTo:"/dashboard"
       
    })
})