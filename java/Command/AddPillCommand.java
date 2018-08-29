/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.User;
import Business.Pills;
import DAO.UserDao;
import DAO.PilDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class AddPillCommand implements Command {

     public String execute(HttpServletRequest request, HttpServletResponse response){
        
            String forwardToJsp = "";
           int pill_identifierID = 0;
            
            String shape = request.getParameter("shape"); 
          String image = request.getParameter("Image");
            PilDao pilldao = new PilDao("healthybunny");
            Pills p = new Pills(pill_identifierID,shape, image);
            boolean success = pilldao.addpill(p);
            HttpSession session = request.getSession();
            if(p !=null){
                session.setAttribute("add", p);
                forwardToJsp = "AdminPillDetail.jsp";
            }else{
                forwardToJsp = "error.jsp";
            }
            return forwardToJsp;
    }
    
}
