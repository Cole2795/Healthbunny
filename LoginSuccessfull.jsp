<%@page import="DAO.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PilDao"%>
<%@page import="Business.Pills"%>
<%@page import="Business.User"%>
<%@include file="internationalisationHeader.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">

        <style>
            .no-js #loader { display: none;  }
            .js #loader { display: block; position: absolute; left: 100px; top: 0; }
            .se-pre-con {
                position: fixed;
                left: 0px;
                top: 0px;
                width: 100%;
                height: 100%;
                z-index: 9999;
                background: url(img/Preloader_2.gif) center no-repeat #fff;
            }
            .pop-up {position:absolute; top:0; left:-999em;}
            .pop-up:target {position:static; left:0;}


            /* The pop-up itself */
            .popBox {
                background:#ffffff;

                /* alternatively fixed width / height and negative margins from 50% */
                position:absolute; left:15%; right:15%; top:20%; bottom:20%;

                z-index:10;

                /* CSS3 where available: rounded corners, drop-shadow, and fade in. */
                box-shadow:2px 2px 4px #4a4a4a;
                opacity:0;
                -webkit-transition: opacity 0.6s ease-in-out;
                -ms-transition: opacity 0.6s ease-in-out;
                transition: opacity 0.6s ease-in-out;
            }

            :target .popBox {position:fixed; opacity:1;}

            /* Light box properties */
            .lightbox {display:none; text-indent:-999em; background:#000; opacity:0.6; width:100%; height:100%; position:fixed; top:0; left:0; bottom:0; right:0; z-index:5;}
            :target .lightbox {display:block;}
            .lightbox:hover {background:#000;}

            /* The pop-ups close link, moved via CSS to the top right of the pop-up */
            .close:link,
            .close:visited {
                position:absolute; top:-1em; right:-1em; display:block; width:1em; height:1em;
                padding:4px 5px 5px 4px;
                font:bold 11px/11px 'Segoe UI', sans-serif; text-align:center; text-decoration:none;
                background:#000; border:2px solid #ddd; color:#fff;
                -moz-border-radius: 1em;
                -webkit-border-radius: 1em;
                border-radius: 1em;
                -moz-box-shadow: 0 0 1px 1px #555;
                -webkit-box-shadow: 0 0 1px 1px #555;
                box-shadow: 0 0 1px 1px #555;
            }
            .close:before {content:"X";}
            .close:hover,
            .close:active,
            .close:focus {box-shadow:0 0 1px 1px #ccc; background:#ccc; color:#000; border:2px solid #000;}
            .close span {text-indent:-999em; display:block;}

            /* The pop-up content div will scroll if it has too much content */
            /* .popScroll {max-height:99%; overflow:hidden; overflow-y:scroll;} removed 17/07/2012 */
            .popScroll {position:absolute; top:9%; left:3%; right:3%; bottom:9%; overflow-y:auto; *overflow-y:scroll; padding-right:0.5em}

            .dropbtn {
                background-color: #4CAF50;
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #ddd}

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #3e8e41;
            }
            imgs{
                float: left;
            }
            .floating-box {
                display: inline-block;
                width: 280px;
                height: 75px;
                margin: 10px;

            }

            .after-box {
                border: 3px solid red; 
            }

            .cf:after {
                content: '';
                display: table;
                clear: both;
            }
            .fb__container {
                max-width: 550px;
                left: 50%;
                position: relative;
                top: 50%;
                transform: translate(-50%, -50%);
                padding: 10px;
                border: 2px solid #e1e6e9;
                border-radius: 5px;
                background-color: grey;
            }
            .fb__container .fb__form-group input {
                width: 48%;
                float: left;
                margin-right: 4%;
            }
            .fb__container .fb__form-group input:nth-child(2) {
                margin-right: 0;
            }
            .fb__container input, .fb__container textarea {
                display: block;
                width: 100%;
                box-sizing: border-box;

                height: 40px;
                font-family: Open Sans;
                font-size: 21px;
                border: none;
                border-radius: 5px;
                padding-left: 15px;
                margin-bottom: 20px;
                transition: border-bottom 0.25s ease;
            }
            .fb__container input::-webkit-input-placeholder, .fb__container textarea::-webkit-input-placeholder {
                color: #888;
                font-weight: 300;
                font-size: 21px;
            }
            .fb__container input:-moz-placeholder, .fb__container textarea:-moz-placeholder {
                color: #888;
                font-weight: 300;
                font-size: 21px;
            }
            .fb__container input::-moz-placeholder, .fb__container textarea::-moz-placeholder {
                color: #888;
                font-weight: 300;
                font-size: 21px;
            }
            .fb__container input:-ms-input-placeholder, .fb__container textarea:-ms-input-placeholder {
                color: #888;
                font-weight: 300;
                font-size: 21px;
            }
            .fb__container input:focus, .fb__container textarea:focus {
                border-bottom: 1px solid #333333;
                outline: none;
            }
            .fb__container textarea {
                max-width: 100%;
                min-height: 150px;
                padding: 10px 15px;
            }
            .fb__container button {
                float: right;
                border: none;
                border-radius: 5px;
                background-color: #333333;
                color: #ebefef;
                font-family: 'Open Sans';
                font-weight: 300;
                font-size: 18px;
                padding: 7px 50px;
                border: 2px solid transparent;
                cursor: pointer;
                transition: all 0.25s ease-in-out;
            }
            .fb__container button:hover {
                border: 2px solid #333333;
                color: #333333;
            }
            .fb__container h1 {
                font-size: 32px;
                font-weight: bold;
                margin: 20px 0;
            }
            .containerss {
                width: 100%;
                height: 50vh;

            }
        </style>
        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">

        <!-- Bootstrap CSS File -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Libraries CSS Files -->
        <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <!-- CSS Library for the video search -->
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-buttons.css'>
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-thumbs.css'>
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.css'>

        <!-- Main Stylesheet File -->
        <link href="css/bootstrap.css" rel="stylesheet">
    <body>


        <% User u = (User) session.getAttribute("login");
            if (u != null) {
        %>
         <div class="se-pre-con"></div>




        <header id="header">
            <div class="container-fluid">

                <div id="logo" class="pull-left">
                    <h1><a href="#intro" class="scrollto"><%=dataBundle.getString("index_healthybunny")%></a></h1>
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                        <li class="menu-active"><a href="#intro"><%=dataBundle.getString("index_home")%></a></li>
                        <li><a href="#services"><%=dataBundle.getString("index_service")%></a></li>
                        <li><a href="#call-to-action"><%=dataBundle.getString("index_video")%></a></li>
                         <li><a href="#contact">Contact Us</a></li>
                        <li><a href="#footer"><%=dataBundle.getString("index_aboutUs")%></a></li>
                        <li class="menu-has-children"><a href=""><%=dataBundle.getString("index_profile")%></a>
                            <ul>
                                <li><a href="profile.jsp"><%=dataBundle.getString("index_viewprofile")%></a></li>
                                <li><a href="index.jsp"><%=dataBundle.getString("index_logout")%></a></li>
                            </ul>
                        </li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header><!-- #header -->

        <!--==========================
          Intro Section
        ============================-->
        <section id="intro">
            <div class="carousel-item active" style="background-image: url('img/intro-carousel/1.jpg');">
                <div class="carousel-container">
                    <div class="carousel-content">
                        <h2><%=dataBundle.getString("index_head")%></h2>
                        <p><%=dataBundle.getString("index_head1")%></p>
                    </div>
                </div>
            </div>
        </section><!-- #intro -->
        <section id="services">
            <div class="container">

                <header class="section-header wow fadeInUp">
                    <h3><%=dataBundle.getString("index_service")%></h3>
                </header>

                <div class="row">

                    <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                        <div class="icon"><i class="ion-ios-analytics-outline"></i></div>
                        <h4 class="title"><a href="medicineSearch.jsp"><%=dataBundle.getString("index_searchmedicine")%></a></h4>
                        <p class="description"><%=dataBundle.getString("index_medicinetitle")%></p>
                    </div>
                    <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                        <div class="icon"><i class="ion-ios-analytics-outline"></i></div>
                        <h4 class="title"><a href="SearchConditions.jsp"><%=dataBundle.getString("index_searchcondition")%></a></h4>
                        <p class="description"><%=dataBundle.getString("index_conditiontitle")%></p>
                    </div>


                    <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                        <div class="icon"><i class="ion-ios-paper-outline"></i></div>
                        <h4 class="title"> <a href="#pop1"><%=dataBundle.getString("pillide")%></a></h4>
                        <p class="description"><%=dataBundle.getString("index_pillselect")%></p>
                    </div>
                    <div id="pop1" class="pop-up">

                        <!-- The pop-up block -->
                        <div class="popBox">

                            <!-- If the content becomes larger than the pop-up this div will scroll the content -->
                            <div class="popScroll">
                                <h2><%=dataBundle.getString("shape")%></h2>
                                <%
                                    PilDao pilldao = new PilDao("healthybunny");
                                    ArrayList<Pills> pills = pilldao.getallList();
                                    for (Pills p : pills) {
                                %>
                                <div class="floating-box">
                                    <div class="imgs">
                                        <figure>

                                            <a href="Userpillselect.jsp?id=<%=p.getPillidenitiferID()%>"><%="<img class='medicineImage' src='Medicine/" + p.getImage() + "'/>"%></a>
                                            <figcaption><%=p.getShape()%></figcaption>

                                        </figure>
                                    </div>
                                </div>
                                <%}
                                %>

                            </div>

                            <!-- The close pop-up link correctly positioned at the end of the content block -->
                            <a href="#links" class="close"><span></span></a>
                        </div>

                        <!-- This link is the light box -->
                        <a href="#links" class="lightbox"></a>
                    </div>
                    <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
                        <div class="icon"><i class="ion-ios-speedometer-outline"></i></div>
                        <h4 class="title"><a href="FrontController?action=communityTopics"><%=dataBundle.getString("community")%></a></h4>
                        <p class="description"><%=dataBundle.getString("communityhead")%></p>
                    </div>

                </div>

            </div>
        </section><!-- #services -->

        <main id="main">
            <!--==========================
                   Search Video Section
                  ============================-->
            <section id="call-to-action" class="wow fadeIn">
                <div class="container text-center">
                    <div id="containers">
                        <form id="search-form" name="search-form" onsubmit="return search()">
                            <div class="fieldcontainers">
                                <input type="search" id="query" class="search-fields" placeholder="<%=dataBundle.getString("searchforvideo")%>">
                            </div>
                        </form>
                        <ul id="results"></ul>
                        <div id="buttons"></div> 
                    </div>

            </section><!-- #call-to-action -->



        </main>
        <!--=============USERS fEEDBACK=========================== -->
        <section id="contact" style="background-image: url('img/about-bg.jpg');">
            <div class="container">

                <header class="section-header">
                    <h3><%=dataBundle.getString("contact")%></h3>
                </header>

                <div class="containerss">
                    <section class="fb__container">
                        <h1 style="color: lightblue">Contact me</h1>
                        <form action="FrontController" method="post" class="fb__form cf">
                            <div class="fb__form-group">
                                
                            </div>
                            <textarea placeholder="Enter Feedback" name="feedback" id="feedback"></textarea>
                            <input type="submit" value="Submit">
                            <input type="hidden" name="action" value="contact"/>
                            
                        </form>
                    </section>
                </div>
        </section>









        <!--==========================
          Footer
        ============================-->
        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">

                        <div class="col-lg-3 col-md-6 footer-info">
                            <h3><%=dataBundle.getString("index_aboutUs")%></h3>
                            <p><%=dataBundle.getString("index_bsclevel")%></p>  </div>

                        <div class="col-lg-3 col-md-6 footer-links">
                            <h4><%=dataBundle.getString("usefullinks")%></h4>
                            <ul>
                                <li><i class="ion-ios-arrow-right"></i> <a href="#"><%=dataBundle.getString("index_home")%></a></li>
                                <li><i class="ion-ios-arrow-right"></i> <a href="#"><%=dataBundle.getString("index_service")%></a></li>
                                <li><i class="ion-ios-arrow-right"></i> <a href="#"><%=dataBundle.getString("termservice")%></a></li>
                                <li><i class="ion-ios-arrow-right"></i> <a href="#"><%=dataBundle.getString("privacy")%></a></li>

                            </ul>
                        </div>

                        <div class="col-lg-3 col-md-6 footer-contact">
                            <h4><%=dataBundle.getString("shareus")%></h4>
                            <p>
                                <a href="https://twitter.com/intent/tweet" class="twitter-hashtag-button" data-size="large" data-text="Using #HealthyBunnys website which is really useful!" data-show-count="false"></a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
                                    <%@include file="footer.jsp" %>

                            </p>




                        </div>

                    </div>
                </div>
            </div>

            <div class="container">
                <div class="copyright">
                    &copy; Copyright <strong><%=dataBundle.getString("index_healthybunny")%></strong>. <%=dataBundle.getString("allreserved")%>
                </div>

            </div>
        </footer><!-- #footer -->

        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/jquery/jquery-migrate.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/superfish/hoverIntent.js"></script>
        <script src="lib/superfish/superfish.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/isotope/isotope.pkgd.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>

        <!-- Template Main Javascript File -->
        <script src="js/main.js"></script>

        <!-- Fancy box for the video search-->
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.pack.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-thumbs.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-media.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-buttons.js'></script>
       <script>
                     $(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");;
	});
                        </script>

        <%
            } else {
                out.println("no user found");
            }
        %>
    </body>
</html>
