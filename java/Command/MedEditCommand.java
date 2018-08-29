/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Business.Medicine;
import Business.Possibleconditions_details;
import DAO.MedicineDao;
import DAO.PossibleconditionDetailDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author campb
 */
public class MedEditCommand  implements Command{
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      //  String forwardToJsp = "";
      
        int pill_identifierID = Integer.parseInt(request.getParameter("pill_identifierID"));
         String name = request.getParameter("name");
         String sideEffects = request.getParameter("sideEffects");
         String warnings = request.getParameter("warnings");
         String howToUse = request.getParameter("howToUse");
         String storage = request.getParameter("storage");
         String overDose = request.getParameter("overDose");
         int medID = Integer.parseInt(request.getParameter("medID"));
         String image = request.getParameter("Image");
         String forwardToJsp = "";
         if(name !=null && medID >0){
             MedicineDao meddao = new MedicineDao("healthybunny");
              Medicine med = new Medicine(medID, pill_identifierID, name, sideEffects, warnings,howToUse, storage, overDose, image );
              int result = meddao.EditMedicine(med);
              HttpSession session = request.getSession();
              if(result == 1){
                  forwardToJsp = "AdminDrugDetail.jsp";
                  session.setAttribute("message", "editSuccess");
              }else{
                  forwardToJsp ="AdminDrugDetails.jsp";
                  session.setAttribute("message", "editFailed");
              }
              
         }else{
             forwardToJsp ="error.jsp";
             HttpSession session = request.getSession();
             session.setAttribute("message", "Failed");
         }
         
         return forwardToJsp;
         
         
    }
    
}
