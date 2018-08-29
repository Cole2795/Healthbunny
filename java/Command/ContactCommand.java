/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Contact;
import Business.User;
import DAO.ContactDao;
import DAO.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */



public class ContactCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
         HttpSession session = request.getSession();
        User u = (User) session.getAttribute("login");
       
            
        String feedback = request.getParameter("feedback");
        ContactDao contactdao = new ContactDao("healthybunny");
        Contact contacts = new Contact(u.getUserId(), feedback);
        boolean success = contactdao.addContact(contacts);
        
        if(contacts !=null){
            session.setAttribute("addcontact", contacts);
            forwardToJsp = "LoginSuccessfull.jsp";
        }else{
            forwardToJsp = "error.jsp";
        }
        
       
        return forwardToJsp;
    }
    
}
