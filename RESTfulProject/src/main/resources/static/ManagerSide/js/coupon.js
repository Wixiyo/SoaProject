(function ($){
    "use strict";
    $("#coupon_name").ready(function(){
        //var user=$.cookie("userId");
        $.ajax({
            url:"http://localhost:8080/coupon/",// 发送请求的URL字符串。
            type : "get", //  请求方式 POST或GET
            dataType : "json", // 预期服务器返回的数据类型。
            async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
            // 请求成功后的回调函数。
            success :function(data){
                $("#coupon_name").text(data.data[0].name)
                $("#coupon_takeoff").text(data.data[0].takeoff)
                $("#coupon_condition").text("满"+data.data[0].con+"元即可减免")
                $("#coupon_id").text(data.data[0].id)
            },
            // 请求出错时调用的函数
            error : function(textStatus, errorThrown) {
                alert("系统ajax交互错误: " + textStatus);
            }
        });
    });
    $("#add_coupon_button").click(function (){
        alert("55");
    })

})(jQuery);