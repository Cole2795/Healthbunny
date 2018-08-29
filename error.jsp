<%@page import="Business.User"%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link href="img/favicon.png" rel="icon">
        <title>Login</title>


        <link rel="stylesheet" href="css/Loginform.css">
        <style>h5{
                color: white;
            }
            .formHeads{
                margin-left: 10%;
                margin-top: 30%;
                color:white;
            }
            h3{
                margin-left:20%;
            }
            a{
                margin-left:30%;
            }</style>

    </head>

    <body>


        <!-- JQUERY AND NORMALIZED CSS INSTALLED-->
        <!-- View settings for more info.-->
        <div id="pageContainer">
            <div id="formContainer">
                <div id="logo"><img src="./img/logo.jpg"/></div>
                <div id="forms">

                    <form>
                        <div class="formHeads">


                            <h2>Something went wrong</h2>
                            <h3>Please try again!</h3>
                            <a href="LoginSuccessfull.jsp">Back to Home</a>

                    </form>
                </div>
            </div>
        </div>



        <script  src="js/Loginform.js"></script>




    </body>

</html>
