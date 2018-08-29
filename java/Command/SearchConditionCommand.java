/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Possibleconditions_details;
import DAO.PossibleconditionDetailDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class SearchConditionCommand implements Command {

  public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "";
        String title = request.getParameter("title");
        if(title !=null && !title.equals("")){
            PossibleconditionDetailDao pcDao = new PossibleconditionDetailDao("healthybunny");
            ArrayList<Possibleconditions_details> p = pcDao.getConditionsDetailbyName(title);
            HttpSession session = request.getSession();
            session.setAttribute("searchs", p);
            forwardToJsp = "Conditionsearch.jsp";
        }else{
            String errorMessage = "not found condition name";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
}
