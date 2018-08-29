/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.User;
import DAO.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class UploadPictureCommand implements Command {

     public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
         String Images = request.getParameter("Images");
        HttpSession session = request.getSession();
         if(Images !=null && Images.equals("")){
             UserDao userdao = new UserDao("healthybunny");
             int u = userdao.updatePicture(Images);
             session.setAttribute("upload", u);
             forwardToJsp = "profile.jsp";
        }else{
             forwardToJsp="error.jsp";
         }
        return forwardToJsp;
     }
}
