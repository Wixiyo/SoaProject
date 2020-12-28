(function ($){
"use strict";
$("#book_name").ready(function(){

    $.ajax({
        url:"http://localhost:8080/bookinfo/999",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            //alert(data.data[0].title);
            $("#book_name").text(data.data[0].title)
            $("#book_prize").text(data.data[0].prize)
            $("#book_author").text(data.data[0].author)
            $("#book_body").text(data.data[0].body)
            $("#book_stock").text(data.data[0].stock)
            $.cookie('book_id',data.data[0].bookId,{ expires: 7, path: '/' });
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("222");
        }
    });
});

    $("#add_to_cart").click(function(){
        $.ajax({
            url:"http://localhost:8080/bookinfo/addtocart",// 发送请求的URL字符串。
            data:{// 发送到服务器的数据。
                //bookId:$.cookie("bookId"),
                //userId:$.cookie("userId"),
                bookId:1,
                userId:"abc",
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
                alert("系统ajax交互错误: " + textStatus);
            }
        });
    });
})(jQuery);