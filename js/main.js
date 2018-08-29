jQuery(document).ready(function( $ ) {

  // Back to top button
  $(window).scroll(function() {
    if ($(this).scrollTop() > 100) {
      $('.back-to-top').fadeIn('slow');
    } else {
      $('.back-to-top').fadeOut('slow');
    }
  });
  $('.back-to-top').click(function(){
    $('html, body').animate({scrollTop : 0},1500, 'easeInOutExpo');
    return false;
  });

  // Initiate the wowjs animation library
  new WOW().init();

  // Initiate superfish on nav menu
  $('.nav-menu').superfish({
    animation: {
      opacity: 'show'
    },
    speed: 400
  });

  // Mobile Navigation
  if ($('#nav-menu-container').length) {
    var $mobile_nav = $('#nav-menu-container').clone().prop({
      id: 'mobile-nav'
    });
    $mobile_nav.find('> ul').attr({
      'class': '',
      'id': ''
    });
    $('body').append($mobile_nav);
    $('body').prepend('<button type="button" id="mobile-nav-toggle"><i class="fa fa-bars"></i></button>');
    $('body').append('<div id="mobile-body-overly"></div>');
    $('#mobile-nav').find('.menu-has-children').prepend('<i class="fa fa-chevron-down"></i>');

    $(document).on('click', '.menu-has-children i', function(e) {
      $(this).next().toggleClass('menu-item-active');
      $(this).nextAll('ul').eq(0).slideToggle();
      $(this).toggleClass("fa-chevron-up fa-chevron-down");
    });

    $(document).on('click', '#mobile-nav-toggle', function(e) {
      $('body').toggleClass('mobile-nav-active');
      $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
      $('#mobile-body-overly').toggle();
    });

    $(document).click(function(e) {
      var container = $("#mobile-nav, #mobile-nav-toggle");
      if (!container.is(e.target) && container.has(e.target).length === 0) {
        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
          $('#mobile-body-overly').fadeOut();
        }
      }
    });
  } else if ($("#mobile-nav, #mobile-nav-toggle").length) {
    $("#mobile-nav, #mobile-nav-toggle").hide();
  }

  // Smooth scroll for the menu and links with .scrollto classes
  $('.nav-menu a, #mobile-nav a, .scrollto').on('click', function() {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var target = $(this.hash);
      if (target.length) {
        var top_space = 0;

        if ($('#header').length) {
          top_space = $('#header').outerHeight();

          if( ! $('#header').hasClass('header-fixed') ) {
            top_space = top_space - 20;
          }
        }

        $('html, body').animate({
          scrollTop: target.offset().top - top_space
        }, 1500, 'easeInOutExpo');

        if ($(this).parents('.nav-menu').length) {
          $('.nav-menu .menu-active').removeClass('menu-active');
          $(this).closest('li').addClass('menu-active');
        }

        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('#mobile-nav-toggle i').toggleClass('fa-times fa-bars');
          $('#mobile-body-overly').fadeOut();
        }
        return false;
      }
    }
  });

  // Header scroll class
  $(window).scroll(function() {
    if ($(this).scrollTop() > 100) {
      $('#header').addClass('header-scrolled');
    } else {
      $('#header').removeClass('header-scrolled');
    }
  });

  // Intro carousel
  var introCarousel = $(".carousel");
  var introCarouselIndicators = $(".carousel-indicators");
  introCarousel.find(".carousel-inner").children(".carousel-item").each(function(index) {
    (index === 0) ?
    introCarouselIndicators.append("<li data-target='#introCarousel' data-slide-to='" + index + "' class='active'></li>") :
    introCarouselIndicators.append("<li data-target='#introCarousel' data-slide-to='" + index + "'></li>");
  });

  $(".carousel").swipe({
    swipe: function(event, direction, distance, duration, fingerCount, fingerData) {
      if (direction == 'left') $(this).carousel('next');
      if (direction == 'right') $(this).carousel('prev');
    },
    allowPageScroll:"vertical"
  });

  // Skills section
  $('#skills').waypoint(function() {
    $('.progress .progress-bar').each(function() {
      $(this).css("width", $(this).attr("aria-valuenow") + '%');
    });
  }, { offset: '80%'} );

  // jQuery counterUp (used in Facts section)
  $('[data-toggle="counter-up"]').counterUp({
    delay: 10,
    time: 1000
  });

  // Porfolio isotope and filter
  var portfolioIsotope = $('.portfolio-container').isotope({
    itemSelector: '.portfolio-item',
    layoutMode: 'fitRows'
  });

  $('#portfolio-flters li').on( 'click', function() {
    $("#portfolio-flters li").removeClass('filter-active');
    $(this).addClass('filter-active');

    portfolioIsotope.isotope({ filter: $(this).data('filter') });
  });

  // Clients carousel (uses the Owl Carousel library)
  $(".clients-carousel").owlCarousel({
    autoplay: true,
    dots: true,
    loop: true,
    responsive: { 0: { items: 2 }, 768: { items: 4 }, 900: { items: 6 }
    }
  });

  // Testimonials carousel (uses the Owl Carousel library)
  $(".testimonials-carousel").owlCarousel({
    autoplay: true,
    dots: true,
    loop: true,
    items: 1
  });

});
$(document).ready(function() {
	$(".fancybox").fancybox();
});



// Searchbar Handler
$(function(){
	var searchField = $('#query');
	var icon = $('#search-btn');
	
	// Focus Event Handler
	$(searchField).on('focus', function(){
		$(this).animate({
			width:'100%'
		},400);
		$(icon).animate({
			right: '10px'
		}, 400);
	});
	
	// Blur Event Handler
	$(searchField).on('blur', function(){
		if(searchField.val() == ''){
			$(searchField).animate({
				width:'45%'
			},400, function(){});
			$(icon).animate({
				right:'360px'
			},400, function(){});
		}
	});
	
	$('#search-form').submit(function(e){
		e.preventDefault();
	});
})


function search(){
	// Clear Results
	$('#results').html('');
	$('#buttons').html('');
	
	// Get Form Input
	q = $('#query').val();

	// Run GET Request on API********************************
	$.get(
		"https://www.googleapis.com/youtube/v3/search",{
			part: 'snippet, id',
			q: q,
			type:'video',
			key: 'AIzaSyDM3hzbxJh4UTjb9CDRPCwYNe_zTNNf_eE'},
			function(data){
				var nextPageToken = data.nextPageToken;
				var prevPageToken = data.prevPageToken;
				
				// Log Data
				console.log(data);
				
				$.each(data.items, function(i, item){
					// Get Output****
					var output = getOutput(item);
					
					// Display Results*****
					$('#results').append(output);
				});
				
				var buttons = getButtons(prevPageToken, nextPageToken);
				
				// Display Buttons
				$('#buttons').append(buttons);
			}
	);
}

// Next Page Function
function nextPage() {
		var token = $('#next-button').data('token');
		var q = $('#next-button').data('query');
	
		// Clear Results
	$('#results').html('');
	$('#buttons').html('');

		// Get Form Input
		q = $('#query').val();

		// Run GET Request on API
		$.get(
				"https://www.googleapis.com/youtube/v3/search", {
						part: 'snippet, id',
						q: q,
						pageToken: token,
						type: 'video',
						key: 'AIzaSyDM3hzbxJh4UTjb9CDRPCwYNe_zTNNf_eE'},
				function(data) {
						var nextPageToken = data.nextPageToken;
						var prevPageToken = data.prevPageToken;

						// Log Data
						console.log(data);

						$.each(data.items, function(i, item) {
								// Get Output
							
								var output = getOutput(item);

								// Display Results
								$('#results').append(output);
						});

						var buttons = getButtons(prevPageToken, nextPageToken);

						// Display Buttons
						$('#buttons').append(buttons);
				}
		);

}


// Prev Page Function
function prevPage() {
		var token = $('#prev-button').data('token');
		var q = $('#prev-button').data('query');
	
		// Clear Results
	$('#results').html('');
	$('#buttons').html('');

		// Get Form Input
		q = $('#query').val();

		// Run GET Request on API
		$.get(
				"https://www.googleapis.com/youtube/v3/search", {
						part: 'snippet, id',
						q: q,
						pageToken: token,
						type: 'video',
						key: 'AIzaSyDM3hzbxJh4UTjb9CDRPCwYNe_zTNNf_eE'},
				function(data) {
						var nextPageToken = data.nextPageToken;
						var prevPageToken = data.prevPageToken;

						// Log Data
						console.log(data);

						$.each(data.items, function(i, item) {
								// Get Output
								var output = getOutput(item);

								// Display Results
								$('#results').append(output);
						});

						var buttons = getButtons(prevPageToken, nextPageToken);

						// Display Buttons
						$('#buttons').append(buttons);
				}
		);

}



// Build Output**********************************************
function getOutput(item) {
		var videoId = item.id.videoId;
		var title = item.snippet.title;
		var description = item.snippet.description;
		var thumb = item.snippet.thumbnails.high.url;
		var channelTitle = item.snippet.channelTitle;
		var videoDate = item.snippet.publishedAt;

		// Build Output String**************************************
		var output = '<li>' +
				'<div class="list-left">' +
				'<img src="'+thumb+'">' +
				'</div>' +
				'<div class="list-right">' +
				'<h3><a class="fancybox fancybox.iframe" href="https://www.youtube.com/embed/'+videoId+'">'+title+'</a></h3>' +
				'<small>By <span class="cTitle">' + channelTitle + '</span> on ' + videoDate + '</small>' +
				'<p>'+description+'</p>' +
				'</div>' +
				'</li>' +
				'<div class="clearfix"></div>' +
				'';

		return output;

}

// Build the buttons
function getButtons(prevPageToken, nextPageToken) {
		if (!prevPageToken) {
				var btnoutput = '<div class="button-container">'+'<button id="next-button" class="paging-button" data-token="'+nextPageToken+'" data-query="'+q+'"' +
						'onclick="nextPage();">Next Page</button></div>';
		} else {
				var btnoutput = '<div class="button-container">'+
						'<button id="prev-button" class="paging-button" data-token="'+prevPageToken+'" data-query="'+q+'"' +
						'onclick="prevPage();">Prev Page</button>' +
						'<button id="next-button" class="paging-button" data-token="'+nextPageToken+'" data-query="'+q+'"' +
						'onclick="nextPage();">Next Page</button></div>';
		}
	
		return btnoutput;
}
// JQUERY
$(function() {
	// Switch to Register
	$(".needAccount, .backLogin").click(function() {
		$("#login, #register, #formContainer").toggleClass("switch");
	});

	// Open Forgot Password
	$(".forgotBtn, .backLoginF").click(function() {
		$("#forgot").toggleClass("forgot");
	});

	// Open Why Register
	$(".regBtn").click(function() {
		$("#whyReg").toggleClass("whyRegister");
	});
});


(function () {
    document.querySelector('.open').addEventListener('click', function () {
        document.querySelector('.modal').classList.add('active');
        document.querySelector('.background').classList.add('active');
    });

    document.querySelector('.close').addEventListener('click', function () {
        document.querySelector('.modal').classList.remove('active');
        document.querySelector('.background').classList.remove('active');
    });
})();