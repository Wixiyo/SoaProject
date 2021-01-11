$("#search_order").click(function(){
    $("#order_list").empty();
    $("#order_list").append('<tr>\n' +
        '    <th>商品编号</th>\n' +
        '    <th>收件人</th>\n' +
        '    <th>寄件地址</th>\n' +
        '    <th>订单金额</th>\n' +
        '    <th>订单状态</th>\n' +
        '    <th>操作</th>\n' +
        '   </tr>');
    $.ajax({
        url:"http://localhost:8080/order/all",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            info=data;
            var total=0;
            for (var i=0;i<data.data[0].length;i++){
                $("#order_list").append('<tr id="the_order'+i+'">\n' +
                    '    <td>\n' +
                    '     <a href="order_detail.html" id="id">'+data.data[0][i].bookId+'</a>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span class="block" id="name">'+data.data[2][i].userName+'</span>\n' +
                    '    </td>\n' +
                    '    <td width="450">\n' +
                    '     <span class="block">'+data.data[2][i].phone+'</span>\n' +
                    '     <address>'+data.data[1][i].address+'</address>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span><i>￥</i><b>'+data.data[0][i].prize+'</b></span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>'+data.data[1][i].status+'</span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <a href="order_detail.html" class="inline-block" title="查看订单"><img src="images/icon_view.gif"/></a>\n' +
                    '     <a class="inline-block" title="删除订单"><img src="images/icon_trash.gif"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
            }

        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });

});

$("#search_order").ready(function (){
    $("#order_list").empty();
    $("#order_list").append('<tr>\n' +
        '    <th>商品</th>\n' +
        '    <th>收件人</th>\n' +
        '    <th>寄件地址</th>\n' +
        '    <th>订单金额</th>\n' +
        '    <th>订单状态</th>\n' +
        '    <th>操作</th>\n' +
        '   </tr>');
    $.ajax({
        url:"http://localhost:8080/order/all",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            info=data;
            var total=0;
            for (var i=0;i<data.data[0].length;i++){
                $("#order_list").append('<tr id="the_order'+i+'">\n' +
                    '    <td>\n' +
                    '     <a>'+data.data[0][i].title+'</a>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span class="block" id="name">'+data.data[2][i].userName+'</span>\n' +
                    '    </td>\n' +
                    '    <td width="450">\n' +
                    '     <span class="block">'+data.data[2][i].phone+'</span>\n' +
                    '     <address>'+data.data[1][i].address+'</address>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span><i>￥</i><b>'+data.data[0][i].prize+'</b></span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>'+data.data[1][i].status+'</span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <a href="order_detail.html?i='+i+'" data-ajax="false" class="inline-block" title="查看订单"><img src="images/icon_view.gif"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
            }

        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});


