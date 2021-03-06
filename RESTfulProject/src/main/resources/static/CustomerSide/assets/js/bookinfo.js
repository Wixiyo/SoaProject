(function ($){
"use strict";
$("#book_name").ready(function(){
    $.ajax({
        url:"http://localhost:8080/bookinfo/id/"+window.location.href.split("?")[1].split("=")[1]+"",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            $("#book_name").text(data.data.title)
            $("#book_prize").text(data.data.prize)
            $("#book_author").text(data.data.author)
            $("#book_body").text(data.data.body)
            $("#book_stock").text(data.data.stock)
            //$.cookie('book_id',data.data[0].bookId,{ expires: 7, path: '/' });
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});

    $("#add_to_cart").click(function(){
        $.ajax({
            url:"http://localhost:8080/bookinfo/addtocart",// 发送请求的URL字符串。
            data:{// 发送到服务器的数据。
                //bookId:$.cookie("bookId"),
                //userId:$.cookie("userId"),
                userId:$.cookie("emailAddress"),
                bookId:window.location.href.split("?")[1].split("=")[1],
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
                alert("已在购物车中");
            }
        });
    });

    $(".buy").click(function (){
        $.ajax({
            url:"http://localhost:8080/order/",// 发送请求的URL字符串。
            data:{// 发送到服务器的数据。
                userId:$.cookie("emailAddress"),
                bookId:window.location.href.split("?")[1].split("=")[1],
                address:$.cookie("address"),
                status:"待发货"
            },
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            type : "post", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                alert("下单："+data.rspMsg);
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("已在购物车中");
            }
        });
    });
})(jQuery);