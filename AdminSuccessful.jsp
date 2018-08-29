<%@page import="DAO.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ContactDao"%>
<%@page import="Business.Contact"%>
<%@page import="Business.User"%>
<%@include file="internationalisationHeader.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
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
        </style>
    <body>

       
             <% User u = (User) session.getAttribute("admin");
                if (u != null) {
            %>
        <div class="se-pre-con"></div>
        
         <header id="header">
            <div class="container-fluid">

                <div id="logo" class="pull-left">
                    <h1><a href="#intro" class="scrollto" style="color:orange"><%=dataBundle.getString("index_healthybunny")%></a></h1>
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                    
                        <li class="menu-active" style="color:orange"><a href="#intro"><%=dataBundle.getString("index_home")%></a></li>
                        <li><a href="#services" style="color:orange"><%=dataBundle.getString("index_service")%></a></li>
                        <li><a href="#call-to-action" style="color:orange"><%=dataBundle.getString("index_video")%></a></li>
                              <li><a href="#contact" style="color:orange">Contact Us</a></li>
                        <li><a href="#footer" style="color:orange"><%=dataBundle.getString("index_aboutUs")%></a></li>
                        <li class="menu-has-children"><a href="" style="color:orange"><%=dataBundle.getString("index_profile")%></a>
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
            <div class="carousel-item active" style="background-image: url('img/office2.jpg');">
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
            <div class="icon"><i class="ion-ios-paper-outline"></i></div>
            <h4 class="title"><a href="AdminDrugDetail.jsp"><%=dataBundle.getString("medicine")%></a></h4>
            <p class="description"><%=dataBundle.getString("index_medicinetext")%></p>
          </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-paper-outline"></i></div>
            <h4 class="title"><a href="AdminConditionsDetail.jsp"><%=dataBundle.getString("condition")%></a></h4>
            <p class="description"><%=dataBundle.getString("conditiontext")%></p>
          </div>
          
          <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
            <div class="icon"><i class="ion-ios-paper-outline"></i></div>
            <h4 class="title"><a href="AdminPillDetail.jsp"><%=dataBundle.getString("pillide")%></a></h4>
            <p class="description"><%=dataBundle.getString("pilltext")%></p>
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
    <section id="contact" <section id="contact" style="background-image: url('img/about-bg.jpg');">
            <div class="container">

                <header class="section-header">
                    <h3><%=dataBundle.getString("contact")%></h3>
                </header>
                     <% Contact m = (Contact) session.getAttribute("addcontact");
                if (m != null) {
                    ContactDao contactdoa = new ContactDao("healthybunny");
                    ArrayList<Contact> contacts = contactdoa.getallMessage();
                    for(Contact c : contacts){
                    UserDao userdao = new UserDao("healthybunny");
                    ArrayList<User> users = userdao.getCommentByUser(c.getUserId());
                    for(User a : users){
                    
            %>
            <br><br>
            <h4 style="color:red"><%=a.getEmail()%> </h4>
                <br>
                <h4 style="color:white"> <%=c.getMessage()%> </h4>
            
            
            
            <%}
}
                }
                %>
            </div>
        </section>


        </main>

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
            }else{
                out.println("no admin found");
}
            %>
    </body>
</html>
