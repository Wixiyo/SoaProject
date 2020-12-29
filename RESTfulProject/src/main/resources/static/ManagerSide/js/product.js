$("#search_product").click(function (){

    for (var i=0;i<4;i++)
    {
        //alert("551");
        $("#product_list").append('<tr id="the_book'+i+'">\n' +
            '    <td>\n' +
            '     <span>\n' +
            '     <input type="checkbox" class="middle children-checkbox"/>\n' +
            '     <i>0</i>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>\n' +
            '      <em id="book_name">天龙八部</em>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="td-name">\n' +
            '      <span class="ellipsis td-name block">这是产品或服务名称(宽度350px,样式自动截取，以省略号表示哦，程序可以处理“截取字符串”)</span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>\n' +
            '      <i>￥</i>\n' +
            '      <em>0.00</em>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>\n' +
            '      <i>￥</i>\n' +
            '      <em>0.00</em>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>\n' +
            '      <em>589</em>\n' +
            '      <i>件</i>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>\n' +
            '      <em>000</em>\n' +
            '     </span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>\n' +
            '     <a href="edit_product.html" title="编辑"><img src="images/icon_edit.gif"/></a>\n' +
            '     <a title="删除"><img src="images/icon_drop.gif"/></a>\n' +
            '    </td>\n' +
            '   </tr>');
        $("#the_book2 #book_name").text("696");
    }
});