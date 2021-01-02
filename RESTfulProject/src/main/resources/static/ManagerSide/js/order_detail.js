$("#peisong").click(function (){
    $.ajax({
        url:"http://localhost:8080/order/"+$("#order_id").text()+"/"+$("#nuo").val(),// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            alert("成功配送");
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});

var info;
$("#peisong").ready(function (){
    $.ajax({
        url:"http://localhost:8080/order/all",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            info=data;
            $("#order_id").text(info.data[1][i].id);
            $("#name").text(info.data[2][i].userName);
            $("#time").text(info.data[1][i].time);
            $("#phone").text(info.data[2][i].phone);
            $("#status").text(info.data[1][i].status);
            $("#address").text(info.data[1][i].address);
            $("#book_name").text(info.data[0][i].title);
            $("#book_body").text(info.data[0][i].body);
            $("#book_prize").text(info.data[0][i].prize);
            $("#total_prize").text(info.data[0][i].prize);
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
    let i=window.location.href.split("?")[1].split("=")[1];
});