$("#search_book_title").ready(function (){
    $("#product_list").empty();
    var title=$("#search_book_title").val();
    var binfo;
    $.ajax({
        url:"http://localhost:8080/bookinfo/"+title,// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            binfo=data;
            $("#product_list").append('<tr>\n' +
                '    <th>ID编号</th>\n' +
                '    <th>商品名</th>\n' +
                '    <th>描述</th>\n' +
                '    <th>备注</th>\n' +
                '    <th>价格</th>\n' +
                '    <th>库存</th>\n' +
                '    <th>条码</th>\n' +
                '    <th>操作</th>\n' +
                '   </tr>');
            for (var i=0;i<binfo.data.length;i++)
            {
                $("#product_list").append('<tr class="book" id="the_book'+i+'">\n' +
                    '    <td>\n' +
                    '     <span>\n' +
                    '     <i id="book_id">0</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_name">教材</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="td-name">\n' +
                    '      <span class="ellipsis td-name block" id="book_body">这是产品或服务名称(宽度350px,样式自动截取，以省略号表示哦，程序可以处理“截取字符串”)</span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_author">张三</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <i>￥</i>\n' +
                    '      <em id="book_prize">0.00</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_stock">589</em>\n' +
                    '      <i>件</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_bar">000</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    //'     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>\n' +
                    '     <a href="edit_product.html" title="编辑"><img src="images/icon_edit.gif"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
                $("#the_book"+i+" #book_name").text(binfo.data[i].title);
                $("#the_book"+i+" #book_body").text(binfo.data[i].body);
                $("#the_book"+i+" #book_author").text(binfo.data[i].author);
                $("#the_book"+i+" #book_stock").text(binfo.data[i].stock);
                $("#the_book"+i+" #book_prize").text(binfo.data[i].prize);
                $("#the_book"+i+" #book_bar").text(binfo.data[i].barcode);
                $("#the_book"+i+" #book_id").text(binfo.data[i].bookId);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});

$("#add_book").click(function (){
    alert("添加成功");
    $.ajax({
        url:"http://localhost:8080/bookinfo/addBook",// 发送请求的URL字符串。
        data:{// 发送到服务器的数据。
            title:$("#title").val(),
            author:$("#author").val(),
            body:$("#body").val(),
            Barcode:$("#Barcode").val(),
            Prize:$("#Prize").val(),
            Stock:$("#Stock").val(),
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        type : "post", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("系统ajax交互错误: " + textStatus);
        }
    });
});

$("#search_product").click(function (){
    $("#product_list").empty();
    var title=$("#search_book_title").val();
    var binfo;
    $.ajax({
        url:"http://localhost:8080/bookinfo/"+title,// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            binfo=data;
            $("#product_list").append('<tr>\n' +
                '    <th>ID编号</th>\n' +
                '    <th>商品名</th>\n' +
                '    <th>描述</th>\n' +
                '    <th>备注</th>\n' +
                '    <th>价格</th>\n' +
                '    <th>库存</th>\n' +
                '    <th>条码</th>\n' +
                '    <th>操作</th>\n' +
                '   </tr>');
            for (var i=0;i<binfo.data.length;i++)
            {
                $("#product_list").append('<tr class="book" id="the_book'+i+'">\n' +
                    '    <td>\n' +
                    '     <span>\n' +
                    '     <i id="book_id">0</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_name">教材</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="td-name">\n' +
                    '      <span class="ellipsis td-name block" id="book_body">这是产品或服务名称(宽度350px,样式自动截取，以省略号表示哦，程序可以处理“截取字符串”)</span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_author">张三</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <i>￥</i>\n' +
                    '      <em id="book_prize">0.00</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_stock">589</em>\n' +
                    '      <i>件</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_bar">000</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    //'     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>\n' +
                    '     <a href="edit_product.html" title="编辑"><img src="images/icon_edit.gif"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
                $("#the_book"+i+" #book_name").text(binfo.data[i].title);
                $("#the_book"+i+" #book_body").text(binfo.data[i].body);
                $("#the_book"+i+" #book_author").text(binfo.data[i].author);
                $("#the_book"+i+" #book_stock").text(binfo.data[i].stock);
                $("#the_book"+i+" #book_prize").text(binfo.data[i].prize);
                $("#the_book"+i+" #book_bar").text(binfo.data[i].barcode);
                $("#the_book"+i+" #book_id").text(binfo.data[i].bookId);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
})