/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Possibleconditions_details;
import DAO.PossibleconditionDetailDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class AddConditionCommand implements Command{
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int possibleCondition_DetailsID = 0;
       //  int possibleConditionID = Integer.parseInt(request.getParameter("possibleConditionID"));
         String title = request.getParameter("title");
         String howCommon = request.getParameter("howCommon");
         String diagnosedBy = request.getParameter("diagnosedBy");
         String treatment = request.getParameter("treatment");
         String madeWorseBy = request.getParameter("madeWorseBy");
         String fact = request.getParameter("fact");
         PossibleconditionDetailDao possibledao = new PossibleconditionDetailDao("healthybunny");
         Possibleconditions_details con = new Possibleconditions_details(possibleCondition_DetailsID,title, howCommon, diagnosedBy, treatment, madeWorseBy,fact);
         boolean success = possibledao.addCondtionpossible(con);
         HttpSession session = request.getSession();
         if(con !=null){
             session.setAttribute("addcond", con);
             forwardToJsp = "AdminConditionsDetail.jsp";
         }else{
             forwardToJsp = "error.jsp";
         }
         return forwardToJsp;
         
         
    }
    
}
