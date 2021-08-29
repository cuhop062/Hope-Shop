app.controller("product-ctrl", function ($scope, $http) {
  // app.controller("product-ctrl", function(){
  $scope.items = [];
  $scope.cates = [];
  $scope.form = [];
  $scope.initialize = function () {
    $http.get("/rest/products").then(resp => {
      $scope.items = resp.data;
      $scope.items.forEach(item => {
        item.createDate = new Date(item.createDate)
      })
    });
    $http.get("/rest/categories").then(resp => {
      $scope.cates = resp.data;
    });
  }
  $scope.initialize();
  $scope.reset = function () {
    $scope.form = {
      createDate: new Date(),
      image: "152feea8.png",
      available: true,
      quantity: 0,
    }
  }

  $scope.update = function () {
    var item = angular.copy($scope.form);
    $http.put(`/rest/products/${item.id}`, item).then(resp => {
      var index = $scope.items.findIndex(p => p.id == item.id);
      $scope.items[index] = item;
      $scope.reset();

      alert("Cập nhật thành công")
    }).catch(error => {
      alert("Cập nhật Sản phẩm lỗi")
      console.log("Error", error);
    });
  }
  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http.post(`/rest/products`, item).then(resp => {
      resp.data.createDate = new Date(resp.data.createDate)
      $scope.items.push(resp.data);
      $scope.reset();
      alert("Thêm thành công")
    }).catch(error => {
      alert("Thêm Sản phẩm lỗi")
      console.log("Error", error);
    });
  }
  $scope.delete = function (item) {
    if (confirm("Bạn có muốn xóa")) {
    $http.delete(`/rest/products/${item.id}`).then(resp => {
      
        var index = $scope.items.findIndex(p => p.id == item.id);
        $scope.items.splice(index, 1);
        $scope.reset();
        alert("Xóa thành công");
    
     
    }).catch(error => {
      alert("Xóa Sản phẩm lỗi");
      console.log("Error", error);
    });
  }
  }
  $scope.edit = function (item) {
    $scope.form = angular.copy(item);
    $(".nav-tabs a:eq(0)").tab('show')
  }

  $scope.imageChanged = function (files) {
    var data = new FormData();
    data.append('file', files[0]);
    $http.post('/rest/upload/images', data, {
      transformRequest: angular.identity,
      headers: { 'Content-Type': undefined }
    }).then(resp => {
      $scope.form.image = resp.data.name;
    }).catch(error => {
      alert("Lỗi upload hình")
      console.log("Error", error);
    });
  }



  $scope.pager = {
    page: 0,
    size: 10,
    get items() {
      var start = this.page * this.size;
      return $scope.items.slice(start, start + this.size);
    },
    get count() {
      return Math.ceil(1.0 * $scope.items.length / this.size);
    },
    first() {
      this.page = 0;
    },
    prev() {
      this.page--;
      if (this.page < 0) {
        this.last();
      }
    },
    next() {
      this.page++;
      if (this.page >= this.count) {
        this.first();
      }
    },
    last() {
      this.page = this.count - 1;

    }
  }
 

});

