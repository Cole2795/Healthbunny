/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;
import Business.Medicine;
import DAO.MedicineDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import services.ServiceValidator;
/**
 *
 * @author campb
 */
public class SearchMedicinedCommand implements Command {

      public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "";
        
        String name = request.getParameter("name");
          ServiceValidator serviceValidator = new ServiceValidator();
                  
        if(serviceValidator.validate(name)){
            MedicineDao mDao = new MedicineDao("healthybunny");
            ArrayList<Medicine> m = mDao.getMedicinebyName(name);
            HttpSession session = request.getSession();
            session.setAttribute("search", m);
            forwardToJsp = "DrugSearch.jsp";
        }else{
            String errorMessage = "not found medicine name";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
    
}
