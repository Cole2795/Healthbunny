<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Discord inspired Login/Register Form</title>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


        <link rel="stylesheet" href="css/Loginform.css">


    </head>

    <body>


        <!-- JQUERY AND NORMALIZED CSS INSTALLED-->
        <!-- View settings for more info.-->
        <div id="pageContainer">
            <div id="formContainers">
                <div id="logo"><img src="./img/logo.jpg"/></div>
                <div id="forms">
                    <form id="whyReg">
                        <div class="fadeUp">
                            <div class="formHead">
                                <h1>WHY REGISTER?</h1>
                            </div>
                            <div class="formDiv">
                                <ul>
                                    <li>Get Access to searching medicines and conditions</li>
                                    <li>Able to comment on posts to share your problems.</li>
                                </ul>
                            </div>
                            <div class="formOther"><a class="regBtn" href="#">Close</a></div>
                        </div>
                    </form>
                    <form id="forgot">
                        <div class="fadeUp">
                            <div class="formHead">
                                <h1>FORGOT PASSWORD?</h1>
                                <p>Looks like you forgot your password</p>
                            </div>
                            <div class="formDiv">
                                <input type="email" placeholder="Type your email"/>
                            </div>
                            <div class="formDiv">
                                <input type="submit" value="SEND EMAIL"/>
                            </div>
                            <div class="formOther"><a class="backLoginF" href="#">BACK TO LOGIN</a><a href="#">CONTACT STAFF</a></div>
                        </div>
                    </form>
                    <form id="login" action="FrontController" method="post">
                        <div class="formHead">
                            <p>Register to gain full access</p>
                        </div>
                        <div class="formDiv">
                            <input type="text" placeholder="Name" name="firstName" required/>
                        </div>
                        <div class="formDiv">
                            <input type="text" placeholder="Surname" name="lastName" required/>
                        </div>
                        <div class="formDiv">
                            <input type="email" placeholder="Email" name="email" required/>
                        </div>
                        <div class="formDiv">
                            <input type="password"  minlength="8" placeholder="Password" name="password" required pattern="[a-zA-Z]+[0-9]{1}+"/>
                        </div>
                        <div class="formDiv">
                            <input type="date" name="DateOfBirth" required/>
                        </div>
                        <div class="formDiv">
                           <input style="color:white" type="file" name="Images"/>
                        </div> 

                        <div class="formDiv">
                            <div class="captcha" required>
                                <div class="spinner" required>
                                    <label>
                                        <input type="checkbox" onclick="$(this).attr('disabled', 'disabled');" required>
                                        <span class="checkmark" required><span>&nbsp;</span></span>
                                    </label>
                                </div>
                                <div class="text" required>
                                    I'm not a robot
                                </div>
                                <div class="logos">
                                    <img src="https://www.google.com/recaptcha/intro/comingsoon/reCAPTCHA_logo.png"/>
                                    <p>reCAPTCHA</p>
                                    <small>Privacy - Terms</small>
                                </div>
                            </div>
                            <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
                            <input type="submit" value="REGISTER"/>
                            <input type="hidden" name="action" value="register"/>
                        </div>
                        <div class="formOther"><a class="backLogin" href="Login.jsp">BACK TO LOGIN</a><a class="regBtn" href="#">WHY REGISTER?</a></div>
                    </form>

                </div>
            </div>
        </div>



        <script  src="js/Loginform.js"></script>




    </body>

</html>
