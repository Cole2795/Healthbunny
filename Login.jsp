<!DOCTYPE html>
<html lang="en" >

    <head>
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
                background: url(img/Preloader_8.gif) center no-repeat #fff;
            }

        </style>

        <meta charset="UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


        <link rel="stylesheet" href="css/Loginform.css">

    </head>

    <body>


        <div id="pageContainer">
            <div id="formContainer">

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
                            </div>
                            <div class="formDiv">
                            </div>
                            <div class="formDiv">
                                <a href="mailto:teamhealthybunny@gmail.com?subject=Password Recovery&body=Hi, Team Healthy Bunny" class="submit">CONTACT STAFF</a>

                            </div>
                            <div class="formOther"><a class="backLoginF" href="#">BACK TO LOGIN</a></div>

                        </div>
                    </form>
                    <form id="login" action="FrontController" method="post">
                        <div class="formHead">

                            <h1>WELCOME BACK</h1>
                            <p>Login to continue</p>
                        </div>
                        <div class="formDiv">
                            <input type="text" placeholder="Email" name="email"/>
                        </div>
                        <div class="formDiv">
                            <input type="password" placeholder="Password" name="password"/>
                        </div>
                        <div class="formDiv">
                            <input type="submit" value="LOGIN"/>
                            <input type="hidden" name="action" value="login"/>
                        </div>
                        <div class="formOther"><a class="forgotBtn" href="#">FORGOT PASSWORD?</a><a class="needAccount" href="#">NEED AN ACCOUNT?</a></div>
                    </form>
                    <form id="register" action="FrontController" method="post">
                        <div class="formHead">
                            <h1>BECOME A MEMBER</h1>
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
                           <input style="color:white" type="file" name="Images" />
                        </div> 

                        <div class="formDiv">
                            <div class="captcha">
                                <div class="spinner">
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
                        <div class="formOther"><a class="backLogin" href="#">BACK TO LOGIN</a><a class="regBtn" href="#">WHY REGISTER?</a></div>
                    </form>
                </div>
            </div>
        </div>

        <script  src="js/Loginform.js"></script>

    </body>

</html>
