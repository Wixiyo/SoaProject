(function ($){
"use strict";
$("#book_name").ready(function(){
   $("#book_name").text("000");
   $("#book_prize").text("100");

   $.ajax({
               url:"http://localhost:8080/bookinfo/999",// 发送请求的URL字符串。
               data:{// 发送到服务器的数据。
                   title:"000",//$("#name").val()
               },
               contentType: "application/x-www-form-urlencoded; charset=utf-8",
               type : "get", //  请求方式 POST或GET
               dataType : "json", // 预期服务器返回的数据类型。
               async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
               // 请求成功后的回调函数。
               success :function(data){
                   alert("系统ajax交互错误: " + textStatus);
               },
               // 请求出错时调用的函数
               error : function(textStatus, errorThrown) {
                   alert("系统ajax交互错误: " + textStatus);
               }
           });
});

$("#register-button").click(function(){

        //alert($.cookie('emailAddress'));
        $.ajax({
            url:"http://localhost:8080/login/register",// 发送请求的URL字符串。
            data:{// 发送到服务器的数据。
                userName:$("#name").val(),
                userId:$("#emailAddress").val(),
                password:$("#password").val(),
                phone:$("#phone").val(),
            },
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            type : "post", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                alert("欢迎："+data.data.userName);
                $.cookie('emailAddress',$("#emailAddress").val(),{ expires: 7, path: '/' });
                $.cookie('name',$("#name").val(),{ expires: 7, path: '/' });
                $(location).attr('href', 'index.html');
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("222");
                //alert("系统ajax交互错误: " + textStatus);
            }
        });
    });
})(jQuery);