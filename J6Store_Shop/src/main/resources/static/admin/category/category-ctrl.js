app.controller("category-ctrl", function ($scope, $http) {
    $scope.items=[];
    $scope.cates=[];
    $scope.form=[];

    $scope.initialize = function(){
        $http.get("/rest/categories").then(resp =>{
          $scope.items = resp.data;
        //   $scope.items.forEach(item => {
        //     item.createDate = new Date(item.createDate)
        //   })
        });
      }
      $scope.initialize();
      $scope.reset = function(){
        $scope.form =  {
        }
      }
      $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
      }
      $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/categories/${item.id}`, item).then(resp =>{
          var index = $scope.items.findIndex(p => p.id == item.id);
          $scope.items[index] = item;
          alert("Cập nhật thành công")
        }).catch(error =>{
          alert("Cập nhật  lỗi")
          console.log("Error", error);
        });
      }
      $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/categories`, item).then(resp =>{
          $scope.items.push(resp.data);
          $scope.reset();
          alert("Thêm thành công")
        }).catch(error =>{
          alert("Thêm Danh mục lỗi")
          console.log("Error", error);
        });
      }
      $scope.delete = function(item){
        if (confirm("Bạn có muốn xóa")) {
        $http.delete(`/rest/categories/${item.id}`).then(resp =>{
          var index = $scope.items.findIndex(p => p.id == item.id);
          $scope.items.splice(index, 1);
          $scope.reset();
          alert("Xóa thành công");
        }).catch(error =>{
          alert("Xóa Danh mục lỗi");
          console.log("Error", error);
        });
      }
      }
      $scope.pager = { 
        page: 0,
        size:5,
        get items(){
          var start = this.page * this.size;
         return $scope.items.slice(start, start + this.size);
        },
        get count(){
          return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
          this.page = 0;
        },
        prev(){
          this.page--;
          if(this.page < 0){
            this.last();
          }
        },
        next(){
          this.page++;
          if(this.page >= this.count){
            this.first();
          }
        },
        last(){
          this.page = this.count - 1;

        }
      }

    
});