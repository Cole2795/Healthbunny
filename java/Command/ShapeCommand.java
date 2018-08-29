/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Medicine;
import DAO.MedicineDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class ShapeCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        if(id > 0 ){
            MedicineDao meddao = new MedicineDao("healthybunny");
            ArrayList<Medicine> m = meddao.getMedicinebypillID(id);
            session.setAttribute("found", m);
            forwardToJsp = "Listofmedicine.jsp";
            
          
        }else{
            String errorMessage = "not found medicine name";
            //HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    
}
