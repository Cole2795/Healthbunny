<%@page import="DAO.UserDao"%>
<%@page import="Business.Response"%>
<%@page import="DAO.ResponseDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.MessageDao"%>
<%@page import="Business.Messages"%>
<%@page import="Business.User"%>

<%@include file="internationalisationHeader.jsp" %>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Message</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css'>
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
            body {
                background-color: #f3f3f3;
            }
            h1 {
                font-size: 21px;
            }
            h2 {
                font-size: 18px;
            }
            h3,
            h4,
            h5,
            h6 {
                font-size: 16px;
            }
            .wall-post {
                border-color: #eae9e9;
                width:100%;
            }
            .wall-post .wall-post-header {
                background-color: #fbfafa;
                border-color: #eae9e9;
            }
            .wall-post .wall-post-header img {
                display: inline-block;
                float: left;
                margin-right: 10px;
            }
            .wall-post .wall-post-header h2 {
                display: inline-block;
                margin: 0;
            }
            .wall-post .wall-post-header h2 small {
                display: block;
            }
            .wall-post .wall-post-footer {
                background-color: #fbfafa;
                border-color: #eae9e9;
            }
            h2{
                font-weight:bold;
                color:black;
                font-size:17px;
            }
            .date{
                font-weight:bold;
                color:black;
                font-size:14px;
            }
            .title{
                font-weight:bold;
                color:black;
                font-size:17px;
            }
            .message{
                font-weight:bold;

                color:black;
                font-size:16px;
            }
            .rdate{
                font-weight:bold;
                color:#002752;
                font-size:14px;
            }
            h3{
                font-weight:bold;
                color:#002752;
                font-size:17px; 
            }
            .response{
                font-weight:bold;
                color:#002752;
                font-size:14px;
            }
            body{
                background: url(img/womanwithphone.jpg)
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#showTextArea').click(function () {
                    $('#myTextArea').show();
                });
            });
        </script>
    </head>

    <body>
        <% User u = (User) session.getAttribute("login");
            if (u != null) {
        %>

        <main id="main">
            <div class="container" style="margin-top:20px;">
                <div class="row">
                    <div class="col-md-12" style="margin-bottom:20px;">
                        <form action="FrontController" method="post">
                            <input type="text" style="margin-bottom:20px;" id="messageTitle" name="messageTitle" placeholder="Enter title..">

                            <div class="status-post">

                                <textarea style="margin-bottom:20px;" name="message"  placeholder="Whats on your mind?" class="form-control" id="message" rows="3"></textarea>

                                <!-- <input type="file" name="file"/> -->
                                <input type="submit" value="comment"/>
                                <input type="hidden" name="action" value="comment"/>  
                                <input type="hidden" name="topicId" value="<%=request.getParameter("id")%>"/>     
                                <input type="hidden" name="userId" value="<%=u.getUserId()%>"/> 
                        </form>      
                    </div>
                </div>       
            </div>
            <%
                MessageDao messagedao = new MessageDao("healthybunny");
                ResponseDao responseDao = new ResponseDao("healthybunny");
                ArrayList<Response> responses = null;
                ArrayList<Messages> messages
                        = messagedao.getMessagesById(Integer.parseInt(
                                request.getParameter("id")));
                for (Messages me : messages) {
                    responses = responseDao.getReponseById(me.getMessageId());
                    UserDao userdao = new UserDao("healthybunny");
                    ArrayList<User> users = userdao.getCommentByUser(me.getUserId());
                    for (User a : users) {


            %>
            <!--posts-->
            <div class="rows">
                <div class="col-md-12s">
                    <div class="panel panel-default wall-post">
                        <div class="panel-heading wall-post-header">

                            <h2> <%=a.getFirstName()%> <%=a.getLastName()%></h2>
                            <p class="date"> <%=me.getMessageDate()%></p>
                        </div>
                        <%
                            }
                        %>
                        <div class="panel-body wall-post-body">
                            <div class="wall-post-content">
                                <p class="title">
                                    <%=me.getMessageTitle()%></p>
                                <p class="message">
                                    <%=me.getMessage()%>
                                </p>
                            </div>
                        </div>
                        <div class="panel-footer wall-post-footer">
                            <div class="wall-post-comments">
                                <!-- Comment -->
                                <ul class="media-list wall-post-comments-list">
                                    <li class="media">
                                        <%
                                            for (Response res : responses) {
                                                ArrayList<User> us = userdao.getCommentByUser(res.getUserId());
                                                for (User eir : us) {
                                        %>
                                        <div class="media-body">
                                            <h3><%=eir.getFirstName()%> <%=eir.getLastName()%></h3> 
                                            <p class="rdate"><%=res.getResponseDate()%></p>





                                            <%
                                                }
                                            %>
                                            <p class="response">
                                                <%=res.getResponseMessage()%>
                                            </p>


                                            <%
                                                }
                                            %>
                                            <hr />

                                        </div>
                                    </li>
                                </ul>
                                <div class="wall-post-comment-box">
                                    <form action="FrontController" method="post">
                                        <input class="form-control" type="text" id="responseMessage" name="responseMessage" placeholder="Enter response..." />
                                        <input type="submit" value="response"/>
                                        <input type="hidden" name="action" value="response"/>  
                                        <input type="hidden" name="messageid" value="<%=me.getMessageId()%>"/> 
                                        <input type="hidden" name="topicId" value="<%=me.getTopicId()%>"/>
                                        <input type="hidden" name="userId" value="<%=u.getUserId()%>"/> 

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/js/bootstrap.min.js'></script>



        <script  src="js/index.js"></script>
    </div>

    <%
            }

        } else {
            out.println("no user found");
        }
    %>

</body>

</html>
