
<%@page import="DAO.PossibleconditionDetailDao"%>
<%@page import="Business.Possibleconditions_details"%>
<%@page import="Business.User"%>
<%@page import="Business.Medicine"%>
<%@page import="DAO.MedicineDao"%>
<%@page import="java.util.ArrayList"%>
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
                    <h1><a href="AdminSuccessful.jsp" class="scrollto"  style="color:lightblue"><%=dataBundle.getString("index_healthybunny")%></a></h1>
                </div>

                <nav id="nav-menu-container">
                    <ul class="nav-menu">
              
                        <li class="menu-active"><a href="#intro"  style="color:lightblue"><%=dataBundle.getString("index_home")%></a></li>
                        
                        <li><a href="#footer" style="color:lightblue"><%=dataBundle.getString("index_aboutUs")%></a></li>
                        <li class="menu-has-children"><a href=""  style="color:lightblue"><%=dataBundle.getString("index_profile")%></a>
                            <ul>
                                <li><a href="Adminprofile.jsp"><%=dataBundle.getString("index_viewprofile")%></a></li>
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
        <%--<section id="intro">
            <div class="carousel-item active" style="background-image: url('img/intro-carousel/1.jpg');">
                <div class="carousel-container">
                    <div class="carousel-content">
                        <h2><%=dataBundle.getString("index_head")%></h2>
                        <p><%=dataBundle.getString("index_head1")%></p>
                    </div>
                </div>
            </div>
        </section><!-- #intro --%>

        <!--==========================
     About Us Section
   ============================-->
        <section id="about" style="background-image: url('img/addmedicine.jpg');">
            <div class="container">

                <header class="section-header">
                    <h3> </h3>
                </header>

                <div class="container">

                    <header class="section-header wow fadeInUp">
                        <h3  style="color:lightblue"><%=dataBundle.getString("addnewcondition")%></h3>
                       <button class="btn open-form"><%=dataBundle.getString("addnewcondition")%></button>
                        
                        <div class="form-popup">
                            <div class="container form-wrapper">
                                <button class="btn close-form"><%=dataBundle.getString("cancel")%></button>
                                <form action="FrontController" method="post" id="my-form" novalidate="novalidate">
                                    <div class="row">
                                        <div class="col-md-12 text-center">
                                            <h1 class="form-title"><%=dataBundle.getString("addnewcondition")%></h1>
                                        </div>
                                    
                                    
                                        <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("title")%></label>
                                            <input type="text" class="form-control" id="title" name="title" placeholder="Enter title" required>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("howCommon")%></label>
                                            <input type="text" class="form-control" id="howCommon" name="howCommon" placeholder="Enter how common" required>
                                        </div>
                                             <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("diagnosedby")%></label>
                                            <input type="text" class="form-control" id="diagnosedBy" name="diagnosedBy" placeholder="Enter diagnosed By" required>
                                        </div>
                                            
                                                 <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("treatment")%></label>
                                            <input type="text" class="form-control" id="treatment" name="treatment" placeholder="Enter treatment" required>
                                        </div>
                                                   <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("madeworseby")%></label>
                                            <input type="text" class="form-control" id="madeWorseBy" name="madeWorseBy" placeholder="Enter Made Worse By" required>
                                        </div>
                                                   <div class="form-group col-md-6">
                                            <label for="name"> <%=dataBundle.getString("fact")%></label>
                                            <input type="text" class="form-control" id="fact" name="fact" placeholder="Enter fact" required>
                                        </div>
                                             <input type="submit" class="btn send-form" value="Add">
                                             <input type="hidden" name="action" value="addcondition"/>
                                    </form>
                            </div>
                        </div>

                        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>



                        <script  src="js/index.js"></script>

                    </header>
                    <style>.table{
                            margin-left: 36%;
                        }</style>

                    <div class="table">

                        <table>
                            <thead>
                                <tr>

                                    <th><%=dataBundle.getString("title")%></th>
                                    <th><%=dataBundle.getString("edit")%></th>
                                    <th><%=dataBundle.getString("delete")%></th>

                                </tr>
                            </thead>
                            <%
                                PossibleconditionDetailDao conDao = new PossibleconditionDetailDao("healthybunny");
                                ArrayList<Possibleconditions_details> conditions = conDao.getallConditionsDetailsList();
                            %> <%
                         for (Possibleconditions_details b : conditions) {
                            %>
                            <tbody>
                                <tr>


                                    <td><%=b.getTitle()%></td>
                                    <td><a href="conditionEdit.jsp?title=<%=b.getTitle()%>"><%=dataBundle.getString("edit")%></a></td>
                                    <td><a href="AdminConDelete.jsp?title=<%=b.getTitle()%>"><%=dataBundle.getString("delete")%></a>


                                </tr>

                            </tbody>
                            <%
                                }

                            %>
                        </table>
                    </div>
                </div>

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
        
        <%            } else {
                out.println("no admin found");
            }
        %>
        <%
            Object resultValue = session.getAttribute("condEdit");
            if (resultValue != null) {
                out.println("");

        %>
        <%        } else {
                out.println("");

            }
        %>

    </body>
</html>


