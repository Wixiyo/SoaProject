(function ($) {
  "use strict";

  $(window).on('load', function () {

    /* preloader activate */
    $(".preloader-activate").removeClass('preloader-active');
  });

  /* offcanvas menu active */
  $("#header-menu-trigger").on("click", function(e){
    e.stopPropagation();
    $("#offcanvas-menu").toggleClass("active");
    $(".body-wrapper").toggleClass("active-overlay");
    $("body").toggleClass("overflow-hidden");
  });

  /* shop filter menu active */
  $("#filter-trigger").on("click", function(e){
    e.stopPropagation();
    $("#shop-filter-menu").slideToggle();
  });

  $("#shop-filter-slideup").on("click", function(e){
    e.stopPropagation();
    $("#shop-filter-menu").slideUp();
  });

  /* remove active class on click other parts of the body */
  $('body').on('click', function(){
    $("#offcanvas-menu").removeClass("active");
    $(".body-wrapper").removeClass("active-overlay");
    $("body").removeClass("overflow-hidden");
  });

  /* svg inject */
  SVGInject($(".injectable"));

  /* background image set */
  var bgSelector = $(".bg-img");
  bgSelector.each(function (index, elem) {
      var element = $(elem),
          bgSource = element.data('bg');
      element.css('background-image', 'url(' + bgSource + ')');
  });

  /* slick slider activation */

  $('.hero-slider-wrapper').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: true,
    arrows: false,
    autoplay: true,
    autoplaySpeed: 5000
  });

  $('.welcome-slider-wrapper').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: true,
    arrows: false,
    autoplay: true,
    autoplaySpeed: 5000
  });

  $('.product-image-slider-wrapper').slick({
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: true,
    arrows: false
  });

  $('.category-slider-wrapper').slick({
    slidesToShow: 5,
    slidesToScroll: 5,
    dots: false,
    arrows: false,
    autoplay: false,
    infinite: true,
    responsive: [

      {
          breakpoint: 370,
          settings: {
              slidesToShow: 3
          }
      }
  ]
  });

  /*$("#search-button").click(function(){
    $.ajax({
      url:"http://localhost:8080/merchandise/",// 发送请求的URL字符串。
      data:{// 发送到服务器的数据。
        code:$("#search-input").val(),
        cost:"33",
        body:"商品描述",
        title:"钢笔"
      },
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      type : "post", //  请求方式 POST或GET
      dataType : "json", // 预期服务器返回的数据类型。
      async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
      // 请求成功后的回调函数。
      success :function(data){
        alert(JSON.stringify(data));
        alert(data.data.title);
      },
      // 请求出错时调用的函数
      error : function(textStatus, errorThrown) {
        alert("系统ajax交互错误: " + textStatus);
      }
    });
  });*/

  $("#user-id").ready(function(){
    //$('#user-id').text($.cookie('emailAddress'));
    $('#user-id').text($.cookie('emailAddress'));
    $('#user-name').text($.cookie('name'));
  });

  /* price range */

  $('#price-range-slider').ionRangeSlider({
		type: 'double',
        skin: 'round',
		hide_min_max: true,
		min: 0,
		max: 500,
		from: 50,
		to: 440
    });


    /* cart plus minus */

    var CartPlusMinus = $('.cart-plus-minus');
    CartPlusMinus.prepend('<div class="dec qtybutton">-</div>');
    CartPlusMinus.append('<div class="inc qtybutton">+</div>');
    $(".qtybutton").on("click", function() {
        var $button = $(this);
        var oldValue = $button.parent().find("input").val();
        if ($button.text() === "+") {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        $button.parent().find("input").val(newVal);
    });

})(jQuery);