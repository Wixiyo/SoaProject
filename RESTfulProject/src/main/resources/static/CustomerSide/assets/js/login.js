(function ($) {
    "use strict";
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
                $.cookie('name',data.data.userName,{ expires: 7, path: '/' });
                $(location).attr('href', 'index2.html');
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("系统ajax交互错误: " + textStatus);
            }
        });
    });

    $("#login-button").click(function (){
        $.ajax({
            url:"http://localhost:8080/login/"+$("#emailAddress").val()+"/"+$("#password").val(),// 发送请求的URL字符串。
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            type : "get", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                if(data.rspCode==="000"){
                    $.cookie('emailAddress',$("#emailAddress").val(),{ expires: 7, path: '/' });
                    $.cookie('name',data.data.userName,{ expires: 7, path: '/' });
                    $(location).attr('href', 'index2.html');
                }
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("系统ajax交互错误: " + textStatus);
            }
        });
    })


})(jQuery);