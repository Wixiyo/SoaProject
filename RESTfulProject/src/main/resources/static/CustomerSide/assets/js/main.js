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