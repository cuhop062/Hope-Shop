app.controller('dashboard-ctrl', function ($scope, $http) {
    $scope.values = [];
    $scope.initialize = function () {
        $http.get(`/rest/orders/sum`).then(resp => {
            $scope.values = resp.data;
            console.log(resp.data);
        })
    }
    $scope.initialize();
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
    });

})
