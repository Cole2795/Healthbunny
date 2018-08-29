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
public class UpdateConditionCommand implements Command {
 public String execute(HttpServletRequest request, HttpServletResponse response) {
   
   
       //int possibleCondition_DetailsID = 0;
     
         String title = request.getParameter("title");
         String howCommon = request.getParameter("howCommon");
         String diagnosedBy = request.getParameter("diagnosedBy");
         String treatment = request.getParameter("treatment");
         String madeWorseBy = request.getParameter("madeWorseBy");
         String fact = request.getParameter("fact");
          String forwardToJsp = "";
          if(title !=null){
          PossibleconditionDetailDao possibledao = new PossibleconditionDetailDao("healthybunny");
         Possibleconditions_details con = new Possibleconditions_details(title, howCommon, diagnosedBy, treatment, madeWorseBy,fact);
        int edit = possibledao.EditCondition(con);
         HttpSession session = request.getSession();
         if(edit == 1){
           forwardToJsp = "AdminConditionsDetail.jsp";
              session.setAttribute("message", "editSuccess");
         }else{
             forwardToJsp = "AdminConditionsDetail.jsp";
              session.setAttribute("message", "editFailed");
         }
         
        
 }else{
              forwardToJsp = "error.jsp";
              HttpSession session = request.getSession();
              session.setAttribute("message", "failed");
          }
          return forwardToJsp;
 }
}
