(function ($){
    "use strict";
    var info;
    $("#order_head").ready(function (){
        $("#order_list").empty();
        var user="123456@123.com";
        user = $.cookie("emailAddress");
        $.ajax({
            url:"http://localhost:8080/order/"+user,// 发送请求的URL字符串。
            type : "get", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                info=data;
                var total=0;
                for (var i=0;i<data.data[0].length;i++){
                    $("#order_list").append('<div class="cart-product border-bottom--medium" id="the_item"'+i+'>\n' +
                        '                <div class="cart-product__image">\n' +
                        '                    <a href="shop-product.html?bookId='+data.data[0][i].bookId+'">\n' +
                        '                        <img src="assets/img/products/product2.png" class="img-fluid" alt="">\n' +
                        '                    </a>\n' +
                        '                </div>\n' +
                        '                <div class="cart-product__content">\n' +
                        '                    <h3 class="title"><a href="shop-product.html?bookId='+data.data[0][i].bookId+'">'+data.data[0][i].title+'</h3>\n' +
                        '                    <span class="category">'+data.data[0][i].author+'</span>\n' +
                        '                    <div class="price">\n' +
                        '                        <span class="discounted-price">价格：'+data.data[0][i].prize+'元<br>购买时间：'+data.data[1][i].time+'</br></span>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="cart-product__status">\n' +
                        '                    <p><span><i class="fa fa-refresh"></i></span>'+data.data[1][i].status+'</p>\n' +
                        '                </div>\n' +
                        '                <div class="cart-product__content">\n' +
                        '                    <p>配送地址：'+data.data[1][i].address+'</p>\n' +
                        '                </div>\n' +
                        '            </div>');
                }

            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("错误");
            }
        });
    });
})(jQuery);