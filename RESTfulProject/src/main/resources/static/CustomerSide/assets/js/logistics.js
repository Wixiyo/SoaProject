function getLocalTime(nS) {
    return new Date(parseInt(nS) * 1000).toLocaleString().replace(/:\d{1,2}$/,' ');
}
$("#logistics").ready(function (){
    var nuo=window.location.href.split("?")[1].split("=")[1];
    $.ajax({
        url:"https://route.showapi.com/2435-1?showapi_appid=451917&nuo="+nuo+"&showapi_sign=f8ca729443174ba1b73952f4c45b677c",//+window.location.href.split("?")[1].split("=")[1],// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            for (var i=0;i<data.showapi_res_body.context.length;i++){
                $("#logistics").append('<li>\n' +
                    '                                    <div class="chat">\n' +
                    '                                        <div class="body">\n' +
                    '                                            <div class="image"><i class="fa fa-paper-plane"></i></div>\n' +
                    '                                            <div class="content">\n' +
                    '                                                <div class="head">\n' +
                    '                                                    <h5>'+data.showapi_res_body.com+'</h5>\n' +
                    '                                                    <span>'+getLocalTime(data.showapi_res_body.context[i].time)+'</span>\n' +
                    '                                                </div>\n' +
                    '                                                <p>'+data.showapi_res_body.context[i].desc+'</p>\n' +
                    '                                            </div>\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                </li>');
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });



});