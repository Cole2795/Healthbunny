/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.User;
import DAO.UserDao;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserServices;

/**
 *
 * @author Cole
 */
public class LoginCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "";

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserServices service = new UserServices(); //testing git working
        HttpSession session = request.getSession();

        if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
            try {
                //call DAO method
                
                UserServices userService = new UserServices();
                User userLoggingIn = userService.login(email, password);
                //session.setAttribute("user", userLoggingIn); // set Attribute with either a valid user or null (userService can return null also)
                if (userLoggingIn != null && userLoggingIn.getisIsAdmin() == 0) {
                   
                        
                    
                    session.setAttribute("login", userLoggingIn);
                    forwardToJsp = "LoginSuccessfull.jsp";
                
                }else if(userLoggingIn !=null && userLoggingIn.getisIsAdmin() == 1){
                     session.setAttribute("admin", userLoggingIn);
                    forwardToJsp = "AdminSuccessful.jsp";
                }
                else {
                    String errorMessage = "no Such user exists/ incorrect password";
                    session.setAttribute("errorMessage", errorMessage);
                    forwardToJsp = "LoginFailed.jsp";
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }

              

            } else {

                forwardToJsp = "Login.jsp";
            }

            return forwardToJsp;
       
    }

}
