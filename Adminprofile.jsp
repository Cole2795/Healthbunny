<%@page import="Business.User"%>
<%@include file="internationalisationHeader.jsp" %>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>AJAX: Profile picture update</title>
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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>

        <link rel="stylesheet" href="css/profile.css">
        <script>function showHide(checked) {
                if (checked === true) {
                    $("#hiddenField").fadeIn();
                } else {
                    $("#hiddenField").fadeOut();
                }

                if (checked === true) {
                    $("#hiddenField2").fadeIn();
                } else {
                    $("#hiddenField2").fadeOut();
                }
            }
            function showHide2(checked) {
                if (checked === true) {
                    $("#hiddenField3").fadeIn();
                } else {
                    $("#hiddenField3").fadeOut();
                }

                if (checked === true) {
                    $("#hiddenField4").fadeIn();
                } else {
                    $("#hiddenField4").fadeOut();
                }
            }


        </script>


    </head>

    <body>
        <% User u = (User) session.getAttribute("admin");
            if (u != null) {
        %> 
        <header id="header">
            <div class="container-fluid">

                <div id="logo" class="pull-left">
                    <h1><a href="AdminSuccessful.jsp" class="scrollto"><%=dataBundle.getString("index_healthybunny")%></a></h1>
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                        Admin
                        <li class="menu-active"><a href="#intro"><%=dataBundle.getString("index_home")%></a></li>
                        <li><a href="#services"><%=dataBundle.getString("index_service")%></a></li>
                        <li><a href="#footer"><%=dataBundle.getString("index_aboutUs")%></a></li>
                        <li class="menu-has-children"><a href=""><%=dataBundle.getString("index_profile")%></a>
                            <ul>
                                <li><a href="Adminprofile.jsp"><%=dataBundle.getString("index_viewprofile")%></a></li>
                                <li><a href="Index.jsp"><%=dataBundle.getString("index_logout")%></a></li>
                            </ul>
                        </li>
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </header><!-- #header -->
            <section id="intro">
            <div class="carousel-item active" style="background-image: url('img/intro-carousel/1.jpg');">
               <div class="carousel-container">
        <div class="containers">
            <div class="profile large">
                <div class="cover"><img src="https://source.unsplash.com/random/700x300"/>
                    <div class="layer">
                        <div class="loader"></div>
                    </div>
                       
                </div>
                <div class="user-info">
                    <div class="profile-pic"><img src=""/>
                        <div class="layer">
                            <div class="loader"></div>
                        </div><a class="image-wrapper" href="#">
                            <form id="profilePictureForm" action="FrontController" method="post">
                                   <input class="hidden-input" id="changePicture" type="file" />
                                    <label class="edit glyphicon glyphicon-pencil" for="changePicture" type="file" name="picture"></label>
                                    <label class="delete glyphicon glyphicon-remove" title="Remove cover" onclick="ramlall()"></label>
                                    <input type="hidden" name ="action" value="upload" />
                               </form></a>
                    </div>
                    <div class="username">
                        <div class="name"><span class="verified"></span>Hello, <%=u.getFirstName()%> <%=u.getLastName()%></div>
                        <div class="about"><%=dataBundle.getString("email")%>: <%=u.getEmail()%></div>
                        
                            <form action="FrontController" method="post" >
                                <%=dataBundle.getString("updatepassword")%> <input type="checkbox" onchange="showHide2(this.checked)" name="chkbox"/><br>
                                <p id="hiddenField3" style="display:none"><input type="password" placeholder="Enter old password" name="oldPassword">
                                    <br>
                                <p id="hiddenField4" style="display:none"><input type="password" placeholder="Enter new Password" name="newPassword">
                                    <br>
                                    <input type="submit" onchange="showHide(this.checked)" value="update">
                                    <input type="hidden" name="action" value="update"/>    



                            </form>  
                    
                    </div>
                </div>
            </div>
        </div>
        <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>



        <script  src="js/index.js"></script>
               </div>
            </div>
            </section>
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
       
        <%
            } else {
                out.println("no user found");
            }
        %>
    </body>

</html>
