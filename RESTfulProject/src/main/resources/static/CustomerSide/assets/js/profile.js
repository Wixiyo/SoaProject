$("#profile-header").ready(function (){
    $("#name").text($.cookie('name'));
    $("#t_name").text($.cookie('name'));
    $("#id").text($.cookie('emailAddress'));
    $("#email").text($.cookie('emailAddress'));
    $("#phone").text("(+86) "+$.cookie('phone'));
    $("#address").text($.cookie('address'));

});
$(".page-title text-center").ready(function (){
    $("#userName").val($.cookie('name'));
    $("#phoneNo").val($.cookie('phone'));
    $("#shippingAddress").val($.cookie('address'));
})
$(".edit-profile-form__button").click(function (){
    $.ajax({
        url:"http://localhost:8080/profile/",// 发送请求的URL字符串。
        data:{// 发送到服务器的数据。
            userName:$("#userName").val(),
            phone:$("#phoneNo").val(),
            address:$("#shippingAddress").val(),
            userId:$.cookie('emailAddress')
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        type : "post", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            $(location).attr('href', 'profile.html');
            $.cookie("name",$("#userName").val());
            $.cookie("phone",$("#phoneNo").val());
            $.cookie("address",$("#shippingAddress").val());
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("系统ajax交互错误: " + textStatus);
        }
    });
})