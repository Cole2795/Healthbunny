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
public class AddmedicineCommand implements Command{
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int medID = 0;
         int pill_identifierID = Integer.parseInt(request.getParameter("pill_identifierID"));
         String name = request.getParameter("name");
         String sideEffects = request.getParameter("sideEffects");
         String warnings = request.getParameter("warnings");
         String howtoUse = request.getParameter("howtoUse");
         String storage = request.getParameter("storage");
         String overDose = request.getParameter("overDose");
         String image = request.getParameter("Image");
         MedicineDao medicinedao = new MedicineDao("healthybunny");
         Medicine med = new Medicine(medID,pill_identifierID, name, sideEffects, warnings,howtoUse, storage, overDose, image );
         boolean success = medicinedao.addMedicine(med);
         HttpSession session = request.getSession();
         if(med !=null){
             session.setAttribute("addmed", med);
             forwardToJsp = "AdminDrugDetail.jsp";
         }else{
             forwardToJsp = "error.jsp";
         }
         return forwardToJsp;
         
         
    }
    
}
