/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.User;
import DAO.UserDao;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ServiceValidator;
import services.UserServices;


public class RegisterCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String forwardToJsp;
            //int userId = 0;
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String DateOfBirth = request.getParameter("DateOfBirth");
            String Images = request.getParameter("Images");
            UserDao us = new UserDao("healthybunny");
            UserServices services = new UserServices();

            User usr = us.getUserbyUserName(email);
            ServiceValidator serviceValidator = new ServiceValidator();

            if (usr != null) {

                System.out.println("User already Exists");
                forwardToJsp = "RegisterFailed.jsp";

            } else {
                if (serviceValidator.validateParam(firstname, lastname, email, password, DateOfBirth)) {
                    if (serviceValidator.validateEmail(email)) {
                        System.out.println("Valid email");
                        byte[] salt = services.generateSalt();
                        String hashPass = Base64.encode(services.getEncryptedPassword(password, salt));
                        String passSalt = Base64.encode(salt);

                        User u = new User(firstname, lastname, email, hashPass, passSalt, DateOfBirth, Images);
                        boolean success = us.addUser(u);
                        HttpSession session = request.getSession();
                        if (success) {
                            if (u != null) {
                                session.setAttribute("UserRegister", u);
                                forwardToJsp = "RegisterSuccessfull.jsp";
                            } else {
                                forwardToJsp = "RegisterFailed.jsp";
                            }
                        } else {
                            forwardToJsp = "RegisterFailed.jsp";

                        }

                    } else {
                        System.out.println("Not valid email");
                        forwardToJsp = "RegisterFailed.jsp";
                    }
                } else {
                    forwardToJsp = "RegisterFailed.jsp";
                }
            }

            return forwardToJsp;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
