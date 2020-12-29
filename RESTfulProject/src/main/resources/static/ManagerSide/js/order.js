$("#search_order").click(function(){

    for (var i=0;i<4;i++)
    {
        $("#order_list").append('<tr id="the_order'+i+'">\n' +
            '    <td>\n' +
            '     <input type="checkbox"/>\n' +
            '     <a href="order_detail.html">2015041803225</a>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span class="block">DeatGhost</span>\n' +
            '     <span class="block">2015-04-18 12:00</span>\n' +
            '    </td>\n' +
            '    <td width="450">\n' +
            '     <span class="block">张三[18309275673]</span>\n' +
            '     <address>陕西省西安市未央区255号</address>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span><i>￥</i><b>58.00</b></span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <span>未付款</span>\n' +
            '    </td>\n' +
            '    <td class="center">\n' +
            '     <a href="order_detail.html" class="inline-block" title="查看订单"><img src="images/icon_view.gif"/></a>\n' +
            '     <a class="inline-block" title="删除订单"><img src="images/icon_trash.gif"/></a>\n' +
            '    </td>\n' +
            '   </tr>');
        $("#the_order0 address").text("696");
    }
    //var i=0;

});
