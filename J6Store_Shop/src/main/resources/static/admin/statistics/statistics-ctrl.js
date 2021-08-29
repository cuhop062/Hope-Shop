app.controller('statistics-ctrl', function ($scope, $http, $rootScope) {
    $scope.items = [];
    $scope.cates = [];
    $scope.months = [];
    $scope.years = [];
    $scope.values = [];
    $rootScope.user = [];
    $scope.initialize = function () {
        $http.get(`/rest/orders/month`).then(resp => {
            $scope.months = resp.data;
            console.log(resp.data);
        })
        $http.get(`/rest/orders/year`).then(resp => {
            $scope.years = resp.data;
            console.log(resp.data);
        })
        $http.get(`/rest/orders/sum`).then(resp => {
            $scope.values = resp.data;
            console.log(resp.data);
        })
    }
    $scope.initialize();
    $scope.getThongke = function (year, month) {
        console.log('year month', year, month);
        $http.get(`/rest/orders/thongkeCate/${year}/${month}`).then(resp => {
            $scope.cates = resp.data;
            console.log(resp.data);
        });
        $http.get(`/rest/orders/thongke/${year}/${month}`).then(resp => {
            console.log(resp.data);
            $scope.items = resp.data;
            $scope.getTotal = function () {
                var total = 0;
                for (var i = 0; i < $scope.items.length; i++) {
                    var product = $scope.items[i];
                    total += (product.price * product.quantity);
                }
                return total;

            }
            // tổng hóa đơn
            $scope.getCount = function () {
                var flags = [],
                    output = [],
                    l = $scope.items.length,
                    i;
                for (i = 0; i < l; i++) {
                    if (flags[$scope.items[i].order.id]) continue;
                    flags[$scope.items[i].order.id] = true;
                    output.push($scope.items[i].order.id);
                }
                return output.length;
            }
            // thống kê sp bán theo loại
            $scope.getCategory = function () {
                var flags = {},
                    output = [],
                    l = $scope.items,
                    i;
                for (i = 0; i < l.length; i++) {
                    if (flags[l[i].product.category.id]) continue;
                    flags[l[i].product.category.id] = true;
                    output.push(l[i]);
                }
                return output;
            }
            console.log($scope.getTotal());
            console.log($scope.items.length);
            console.log($scope.getCount());
            console.log($scope.getCategory());
        })

    }
     // pieChart
 $(document).ready(function () {
    $.ajax({
        type: 'GET',
        dataType: "json",
        contentType: "application/json",
        url: 'http://localhost:8080/rest/orders/inventoryByCategory',

        success: function (result) {
            google.charts.load('current', {
                'packages': ['corechart']
            });
            google.charts.setOnLoadCallback(function () {
                drawChart(result);
            })
        }
    });

    function drawChart(result) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', "Name");
        data.addColumn('number', "Quantity");
        var dataArray = [];
        $.each(result, function (i, obj) {
            dataArray.push([obj.group.name, obj.sum])
        });

        data.addRows(dataArray);

        var piechart_options = {
            title: 'Pie Chart: How Much Category Order',
            width: 350,
            height: 350
        };

        var piechart = new google.visualization.PieChart(document.getElementById('chart_div'));
        piechart.draw(data, piechart_options);


        //  var barchart_options = {
        //      title: 'Barchart: How Much Category By Order',
        //      width: 400,
        //      heigth: 300,
        //      legend: 'none'
        //  }

        //  var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
        //  barchart.draw(data, barchart_options);
    }
})
});