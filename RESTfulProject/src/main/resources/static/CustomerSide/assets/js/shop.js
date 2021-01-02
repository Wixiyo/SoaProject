function showBookList(i,info)
{
    $("#book_list").append('<div class="col-6" id="the_book'+i+'">\n' +
        '                            <div class="grid-product space-mb--20">\n' +
        '                                <div class="grid-product__image">\n' +
        '                                    <a href="shop-product.html?bookId='+info.data[i].bookId+'">\n' +
        '                                        <img src="assets/img/products/product2.png" class="img-fluid" alt="">\n' +
        '                                    </a>\n' +
        '                                    <button class="icon"><img src="assets/img/icons/heart-dark.svg" class="injectable" alt=""></button>\n' +
        '                                </div>\n' +
        '                                <div class="grid-product__content">\n' +
        '                                    <h3 class="title"><a href="shop-product.html?bookId='+info.data[i].bookId+'" id="the_book_name">Lipstick</a></h3>\n' +
        '                                    <span class="category" id="the_book_author">Cosmetics</span>\n' +
        '                                    <div class="price">\n' +
        '                                        <span class="discounted-price" id="the_book_prize">$30</span>\n' +
        '                                    </div>\n' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </div>');
    $("#the_book"+i+" #the_book_name").text(info.data[i].title);
    $("#the_book"+i+" #the_book_author").text(info.data[i].author);
    $("#the_book"+i+" #the_book_prize").text(info.data[i].prize);
}

$("#search-input").ready(function (){
    //alert("55");
    var info;
    $.ajax({
        url:"http://localhost:8080/bookinfo/",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            info=data;
            for (var i=0;i<info.data.length;i++)
            {
                showBookList(i,info);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});

$("#search-button").click(function (){
    var title=$("#search-input").val();
    var info;
    $.ajax({
        url:"http://localhost:8080/bookinfo/"+title,// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            $("#book_list").empty();
            info=data;
            for (var i=0;i<info.data.length;i++)
            {
                showBookList(i,info);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});
