"use strict";
var PictureUpdate = (function(options) {
  function PictureUpdate() {
    var defaults = {
      profileClass: 'profile-pic',
      coverClass: 'cover'
    };
    var actual = $.extend({}, defaults, options || {});
    this.profile = $("." + actual.profileClass); //direct parent
    this.cover = $("." + actual.coverClass); //direct parent
    this.inpPicture = $("#changePicture");
    this.updateProfile();
    this.updateCover();
  }
  PictureUpdate.prototype.updateProfile = function() {
    var _this = this;
    var input = $("input", this.profile);
    input.change(function(e) {
      var img = URL.createObjectURL(e.target.files[0]);
      _this.fireAJAX(null, img, _this.profile);
    });
  };
  PictureUpdate.prototype.updateCover = function() {
    var _this = this;
    var input = $("input", this.cover);
    input.change(function(e) {
      var img = URL.createObjectURL(e.target.files[0]);
      _this.fireAJAX(null, img, _this.cover);
    });
  };

  PictureUpdate.prototype.fireAJAX = function(url, data, element) {
    var _this = this;
    $.ajax({
      type: "POST",
      data: data,
      beforeSend: function() {
        _this.startLoader(element);
      },
      success: function() {
        setTimeout(function() {
          _this.destroyLoader(element);
          $("> img", element).attr("src", data);
        }, 2000);
      }
    });
  };
  PictureUpdate.prototype.startLoader = function(element) {
    var loader = $(".layer", element);
    loader.addClass("visible");
  };
  PictureUpdate.prototype.destroyLoader = function(element) {
    var loader = $(".layer", element);
    loader.removeClass("visible");
  };
  PictureUpdate.prototype.abc = function() {
    var _this = this;
    var input = $("input", this.profile);
    $("> img", _this.profile).attr("src", "");
    input.val('');
  };
  return PictureUpdate;
})();

PictureUpdate = new PictureUpdate();

function ramlall() {
  PictureUpdate.abc();
}

modalAnimation();
function modalAnimation() {
  
  var $modal = $('.c-modal');
  
  var $button = $('.js-modal');
  var $close = $('.js-close-modal');
  var $submit = $('.js-submit-modal');
  
  $modal.hide();

  $button.on('click', function() {
    
    // give empty display property to css 'display: "" '
    $modal.css('display', '');
    
    // sets the target to the correct modal
    var target = "#" + $(this).data("target");
    
    // hide any modal other than the one clicked
    $modal.not(target).hide();
    
    // adds 'js-animate-in' for the modal clicked
    $(target).addClass('js-animate');
    
    // checked to see which modal was clicked
    console.log(target);

  });
  
  // Closes the modal by animating it down and out
  $close.on('click', function() {
      
     $modal.removeClass('js-animate');
     $modal.css('display', '');
     $modal.addClass('js-animate-out');
    
    setTimeout(function() {
        $modal.removeClass('js-animate-out');
        $modal.css('display', 'none');
      }, 1000);
   
  });
  
  // submits the form
  $submit.on('click', function() {
    $submit.toggleClass('js-loading');
    // $submit.css('display', "block");
    setTimeout(function() {
      $submit.removeClass('js-loading');
      $submit.addClass('js-animate-submit');
    }, 2000);
  })
  
}
$(document).ready(function() {

	$('.open-form').click(function() {
		$('.form-popup').show();
	});
	$('.close-form').click(function() {
		$('.form-popup').hide();
	});
  
	$('.reset-form').click(function() {
		$('.success-message').show();
    $('#my-form').trigger( 'reset' );

    setTimeout(function() {
	    $('.success-message').hide()
    }, 1500);
	});

	$(document).mouseup(function(e) {
		var container = $(".form-wrapper");
		var form = $(".form-popup");

		if (!container.is(e.target) && container.has(e.target).length === 0) {
			form.hide();
		}
	});


});

