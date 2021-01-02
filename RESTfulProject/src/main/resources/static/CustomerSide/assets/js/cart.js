(function ($){
    "use strict";
    var info;
    $("#cart_head").ready(function(){
        $("#cart_list").empty();
        var user="123456@123.com";
        user = $.cookie("emailAddress");
        $.ajax({
            url:"http://localhost:8080/cart/"+user,// 发送请求的URL字符串。
            type : "get", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                info=data;
                var total=0;
                for (var i=0;i<data.data.length;i++){
                    total=total+data.data[i].prize;
                    $("#cart_list").append('<div class="cart-product border-bottom--medium" id="the_cart"'+i+'>\n' +
                        '                <div class="cart-product__image">\n' +
                        '                    <a href="shop-product.html?bookId='+data.data[i].bookId+'">\n' +
                        '                        <img src="assets/img/products/product2.png" class="img-fluid" alt="">\n' +
                        '                    </a>\n' +
                        '                </div>\n' +
                        '                <div class="cart-product__content">\n' +
                        '                    <h3 class="title"><a href="shop-product.html?bookId='+data.data[i].bookId+'">'+data.data[i].title+'</a></h3>\n' +
                        '                    <span class="category">'+data.data[i].author+'</span>\n' +
                        '                    <div class="price">\n' +
                        '                        <span class="discounted-price">￥<br>'+data.data[i].prize+'</br></span>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <div class="cart-product__counter">\n' +
                        '                    <div class="cart-plus-minus">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </div>');
                }
                $("#total_prize").text(total);
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("错误");
            }
        });
    });

    $("#check_out").click(function (){
        alert("已下单1");
        var user="123456@123.com";
        user = $.cookie("emailAddress");
        for(var i=0;i<info.data.length;i++){
            $.ajax({
                url:"http://localhost:8080/order/",// 发送请求的URL字符串。
                data:{// 发送到服务器的数据。
                    //bookId:$.cookie("bookId"),
                    //userId:$.cookie("userId"),
                    userId:$.cookie("emailAddress"),
                    bookId:info.data[i].bookId,
                    address:$.cookie("address"),
                    status:"待发货"
                },
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type : "post", //  请求方式 POST或GET
                dataType : "json", // 预期服务器返回的数据类型。
                async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
                // 请求成功后的回调函数。
                success :function(data){
                    alert(data.rspMsg);
                },
                // 请求出错时调用的函数
                error : function(textStatus, errorThrown) {
                    alert("错误");
                }
            });
        }
    })



})(jQuery);